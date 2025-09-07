import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] dp;
    static int[] dir = {-1, 0, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		dp = new int[N+1][M][3];
		
		for(int i=1; i<=N; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<M; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
		        
		        for(int k=0; k<3; k++){
		            if(j+dir[k] < 0 || j+dir[k] >= M){
		                dp[i][j][k] = map[i][j] + 101*N;
		                continue;
		            }
		            dp[i][j][k] = map[i][j] + Math.min(dp[i-1][j+dir[k]][(k+1)%3], dp[i-1][j+dir[k]][(k+2)%3]);
		        }
		    }
		}
		int answer = dp[N][0][0];
		for(int i=0; i<M; i++){
		    for(int j=0; j<3; j++){
		        answer = Math.min(answer, dp[N][i][j]);
		    }
		}
		System.out.print(answer);
	}
}
