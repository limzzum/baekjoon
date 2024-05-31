import java.util.*;
import java.io.*;

public class Main{

    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int N, M;
    static int[][] map;
    static int answer;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    map = new int[N][M];
	    answer = N * M * 2;
	    
	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<M; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            for(int k=1; k<= map[i][j]; k++){
	                countOpenArea(i, j, k);
	            }
	        }
	    }
	    
	    System.out.print(answer);
	}
	
	private static void countOpenArea(int r, int c, int height){
	    for(int i=0; i<4; i++){
	        int nr = r + row[i];
	        int nc = c + col[i];
	        
	        if(nr < 0 || nr >= N || nc < 0 || nc >= M){
	            answer += 1;
	            continue;
	        }
	        
	        if(map[nr][nc] < height){
	            answer += 1;
	        }  
	    }
	}
    
}
