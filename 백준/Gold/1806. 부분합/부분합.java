
import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> qp = new ArrayDeque<>();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        String [] line = br.readLine().split(" ");

        if(S==0){
            System.out.println(0);
            return;
        }
        if(S==1){
            System.out.println(1);
            return;
        }
        int [] nums = new int[N];
        int sum = 0;
        int size = 0;
        int answer = N+1;

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(line[i]);
            qp.add(nums[i]);
            sum +=nums[i];
            size +=1;

            while(sum>=S) {
                answer = Math.min(answer, size);
                sum -= qp.poll();
                size -= 1;
            }
        }
        if(answer == N+1){
            System.out.println(0);
            return;
        }
        System.out.println(answer);
    }

}