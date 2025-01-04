import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static final int[] row = {-1, 0};
	static final int[] col = {0, -1};
	static int N;
	static int[][] map;
	static BigInteger[][] dp;
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
	    N = Integer.parseInt(br.readLine());
	    map = new int[N][N];
	    dp = new BigInteger[N][N];
	    
	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<N; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    dfs(N-1, N-1);
	    System.out.print(dp[N-1][N-1]);
	}
	
	private static BigInteger dfs(int r, int c){
	    if(r == 0 && c == 0){
	        return BigInteger.valueOf(1);
	    }
	    if(dp[r][c] != null){
	        return dp[r][c];
	    }
        dp[r][c] = BigInteger.valueOf(0);
	    int nr, nc;
        for(int i=0; i<2; i++){
	        for(int j=1; j<N; j++){
                nr = r + row[i] * j;
	            nc = c + col[i] * j;
	        
	            if(nr < 0 || nc < 0){
	                break;
	            }
	        
	            if(map[nr][nc] == j){
	                dp[r][c] = dp[r][c].add(dfs(nr, nc));
	            }
	        }
	   }
	   return dp[r][c];
	}
}
