import java.util.*;
import java.io.*;

public class Main{
    
    static int N, K;
    static int[] nums;
    static int[] dp;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    nums = new int[N];
	    dp = new int[K+1];
	    for(int i=0; i<N; i++){
	        nums[i] = Integer.parseInt(br.readLine());
	    }
	    
	    dp[0] = 1;
	    for(int i=0; i<N; i++){
	        for(int j=nums[i]; j<=K; j++){
	            dp[j] += dp[j-nums[i]];
	        }
	    }
	    
	    System.out.println(dp[K]);
	}
}
