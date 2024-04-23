import java.util.*;
import java.io.*;
import java.math.*;

public class Main{

    static int N;
    static BigInteger[] dp;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new BigInteger[N+2];
        
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        
        for(int i=2; i<= N; i++){
            dp[i] = dp[i-1].add(dp[i-2]);
        }
        System.out.println(dp[N]);
        
	}
}
