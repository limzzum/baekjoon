import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] staffs = new int[N];
        int max = 0;
        for(int i=0; i<N; i++){
            staffs[i] = Integer.parseInt(br.readLine());
            if(staffs[i]>max){
                max = staffs[i];
            }
        }

        long maxTime = (long)(M/N+1)*max;

        long left =1;
        long right =maxTime;
        long mid = (left+right)/2;

        long answer = maxTime;
        while (left<=right){
            mid = (left+right)/2;
            long sum = 0;
            for (int i=0; i<N; i++){
                sum += mid/staffs[i];
            }

            if(sum>=M){
                answer = Math.min(answer, mid);
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        System.out.println(answer);
    }
}
