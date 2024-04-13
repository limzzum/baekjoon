import java.util.*;
import java.io.*;

public class Main{
    
    static int[][] dp;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = null;

	    int T = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    int N;
	    int M;
	    for(int i=0; i<T; i++){
	        st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        if(N < M){
	            int temp = N;
	            N = M;
	            M = temp;
	        }
	        dp = new int[N+1][M+1];
            
	        sb.append(dfs(N, M)).append("\n");
	    }
	    
	    System.out.println(sb);
	}
	
	private static int dfs(int n, int m){
	    if(dp[n][m] != 0){
	        return dp[n][m];
	    }
	    
	    if(m == 0 || n == m){
	        return dp[n][m] = 1;
	    }

	    return dp[n][m] = dfs(n-1, m-1) + dfs(n-1, m);
	}
}
