import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String [] line = br.readLine().split(" ");
        int [] nums = new int[N+1];

        int[] count = new int[M];
        for (int i=1; i<=N; i++){
            nums[i] = (nums[i-1] + Integer.parseInt(line[i-1])) % M;
            count[nums[i]] +=1;
        }

        long sum = count[0];

        for (int i=0; i<M; i++){
            if(count[i] <2){
                continue;
            }
            sum += ((long)count[i]*(count[i]-1))/2;

        }

        System.out.println(sum);

    }
}