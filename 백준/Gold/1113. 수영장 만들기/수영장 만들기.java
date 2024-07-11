import java.util.*;
import java.io.*;

public class Main{

    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static List<Integer> cornerRow = new ArrayList<>();
    static List<Integer> cornerCol = new ArrayList<>();
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] count = new int[10];
    static int cnt;
    static int answer;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    map = new int[N][M];
	    isVisited = new boolean[N][M];
	    cornerRow.addAll(List.of(0, N-1));
	    cornerCol.addAll(List.of(0, M-1));
	    
	    for(int i=0; i<N; i++){
	        int idx = 0;
	        for(char w : br.readLine().toCharArray()){
	            map[i][idx] = w - '0';
	            count[map[i][idx]] += 1;
	            idx += 1;
	        }
	    }
	    
	    for(int i=2; i<=9; i++){
	        cnt = 0;
	        isVisited = new boolean[N][M];
	        for(int r : cornerRow){
	            for(int j=0; j<M; j++){
	                if(!isVisited[r][j] && map[r][j] < i){
	                    dfs(r, j, i);
	                }
	            }
	        }
	    
	        for(int c : cornerCol){
	            for(int j=0; j<N; j++){
	                if(!isVisited[j][c] && map[j][c] < i){
	                    dfs(j, c, i);
	                }
	            }
	        }
	        
	        answer += count[i-1] - cnt;
	        count[i] += count[i-1];

	    }
	    
	    System.out.print(answer);
	    
	}
	
	private static void dfs(int r, int c, int height){
	    isVisited[r][c] = true;
	    cnt += 1;

	    for(int i=0; i<4; i++){
	        int nr = r + row[i];
	        int nc = c + col[i];
	        
	        if(nr < 0 || nr >= N || nc < 0 || nc >= M){
	            continue;
	        }
	        if(!isVisited[nr][nc] && map[nr][nc] < height){
	            dfs(nr, nc , height);
	        }
	    }  
	}
	
}
