import java.util.*;
import java.io.*;

public class Main{
    
    static int T;
    static long[] dp = new long[50001];
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());
        init();
        
        StringBuilder sb = new StringBuilder();
	    for(int i=0; i<T; i++){
	        int n = Integer.parseInt(br.readLine());
	        if(n == 3){
	            sb.append(2);
	        }else if(n == 1 || n == 2){
	            sb.append(dp[n]);
	        }else {
	            sb.append((dp[n/2] + dp[n/2 - 1])%1_000_000_009);
	        }
	        sb.append("\n");
	    }
	    
	    System.out.print(sb);
	}
	
	private static void init(){
	    dp[1] = 1L;
	    dp[2] = 2L;
	    dp[3] = 4L;
	    
	    for(int i=4; i<= 50000; i++){
	        dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;
	    }
	}
	
}
