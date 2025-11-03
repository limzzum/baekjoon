import java.util.*;
import java.io.*;

public class Main {

    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int N, M;
    static char[][] map;
    static boolean[][] isVisited;
    static int ourScore;
    static int enemyScore;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    map = new char[N][M];
	    isVisited = new boolean[N][M];
	    
	    for(int i=0; i<N; i++){
	        map[i] = br.readLine().toCharArray();
	    }
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            if(!isVisited[i][j]){
	                if(map[i][j] == 'W'){
	                    ourScore += (int) Math.pow(dfs(i,j,map[i][j],1), 2);
	                }else {
	                    enemyScore += (int) Math.pow(dfs(i,j,map[i][j],1), 2);
	                }
	            }
	        }
	    }
        
	    System.out.print(ourScore+" "+enemyScore);
	}
	
	private static int dfs(int r, int c, char color, int cnt){
	    int sum = 1;
	    isVisited[r][c] = true;
	    int nr, nc;
	    for(int i=0; i<4; i++){
	        nr = r + row[i];
	        nc = c + col[i];
	        if(nr < 0 || nr >= N || nc < 0 || nc >= M){
	            continue;
	        }
	        if(isVisited[nr][nc] || map[nr][nc] != color){
	            continue;
	        }
	        sum += dfs(nr, nc, color, cnt + 1);
	    }
	    return sum;
	}
}
