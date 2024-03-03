import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dp;
    static final int DIVIDE_NUM = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        if(N==1){
            System.out.println(1);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=N; i++){
            if(dp[i-1] + dp[i-2] == 0){
                dp[i] = 0;
                continue;
            }
            dp[i] = (dp[i-1] + dp[i-2])%DIVIDE_NUM;
        }
        if(dp[N]==0){
            System.out.println(0);
            return;
        }
        System.out.println(dp[N] % DIVIDE_NUM);



    }

}
