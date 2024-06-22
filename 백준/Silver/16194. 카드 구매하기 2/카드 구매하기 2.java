import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static int[] prices;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        prices = new int[N+1];
        dp = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            prices[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[1] = prices[1];
        for(int i=2; i<= N; i++){
            dp[i] = prices[i];
            for(int j=1; j<i; j++){
                dp[i] = Math.min(dp[i], dp[i-j] + dp[j]);
            }
        }
        
        System.out.print(dp[N]);        
    }
}
