import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][2];

        int max = 0;
        for (int i = 1; i < N+1; i++) {
            int num = Integer.parseInt(br.readLine());
            dp[i][0] = num;
            dp[i][1] = 1;
            for(int j=i-1; j>=1; j--){
                if(dp[j][0]<num){
                    dp[i][1] = Math.max(dp[i][1],dp[j][1]+1);
                    if(dp[i][1]>max){
                        max = dp[i][1];
                        break;
                    }
                    if(dp[j][0] == num-1){
                        break;
                    }
                }
            }

        }

        System.out.println(N-max);




    }
}
