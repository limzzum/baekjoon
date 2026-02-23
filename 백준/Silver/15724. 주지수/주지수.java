import java.util.*;
import java.io.*;

public class Main {
    
    static int N,M,K;
    static int[][] map;
    static int[][] dp;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    map = new int[N+1][M+1];
	    dp = new int[N+1][M+1];
	    
	    for(int i=1; i<=N; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=1; j<=M; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	            dp[i][j] = map[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
	        }
	    }
	    
	    K = Integer.parseInt(br.readLine());
	    int startR, startC, endR, endC;
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<K; i++){
	        st = new StringTokenizer(br.readLine());
	        startR = Integer.parseInt(st.nextToken());
	        startC = Integer.parseInt(st.nextToken());
	        endR = Integer.parseInt(st.nextToken());
	        endC = Integer.parseInt(st.nextToken());
	        sb.append(dp[endR][endC] - dp[endR][startC-1] - dp[startR-1][endC] + dp[startR-1][startC-1]).append("\n");
	    }
	    System.out.print(sb);
	}
}
