package P1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1654 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        long[] lanson = new long[N];
        for (int i=0; i<N; i++){
            lanson[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(lanson);
        long left = 1;
        long right = lanson[lanson.length-1];
        long mid;
        int sum;

        long answer = 0;
        while(left<=right){
            sum =0;
            mid = (left+right) /2;
            for(long lan:lanson){
                sum += lan/mid;
            }
            if(sum>=target){
                answer = mid;
                left = mid +1;
            }
            if(sum<target){
                right = mid -1;
            }
        }
        System.out.println(answer);

    }
}
