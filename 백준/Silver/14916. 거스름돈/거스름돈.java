import java.util.*;
import java.io.*;

public class Main{
    
    private static int N;
    private static int[] dp;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		dfs(5, 0);
		dfs(2, 0);
		
		if(dp[N] == 0){
		    System.out.print(-1);
		}else {
		    System.out.print(dp[N]);
		}
	}
	
	private static void dfs(int num, int pre){
	    if(num > N){
	        return;
	    }
	    if(dp[num] != 0){
	        return;
	    }
	    
	    dp[num] = dp[pre] + 1;
	    
	    dfs(num + 5, num);
	    dfs(num + 2, num);
	}

}
