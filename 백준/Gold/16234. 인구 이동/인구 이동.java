import java.util.*;
import java.io.*;

public class Main{

    static class Pos {
        int r;
        int c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int N, L, R;
    static int[][] map;
    static boolean[][] isVisited;
    static List<Pos> poses = new ArrayList<>();
    static boolean isMoved;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    L = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][N];
	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<N; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    int day = -1;
	    isMoved = true;
	    while(isMoved){
	        day += 1;
	        isMoved = false;
	        isVisited = new boolean[N][N];
	        for(int i=0; i<N; i++){
	            for(int j=0; j<N; j++){
	                if(!isVisited[i][j]){
	                    int sum = dfs(new Pos(i,j));
	                    move(sum);
	                }
	            }
	        }
	    }
	    
	    System.out.print(day);
	    
	}
	
	private static int dfs(Pos pos){
	    isVisited[pos.r][pos.c] = true;
	    poses.add(pos);
	    
	    int sum = map[pos.r][pos.c];
	    for(int i=0; i<4; i++){
	        int nr = pos.r + row[i];
	        int nc = pos.c + col[i];
	        
	        if(nr < 0 || nr >= N || nc < 0 || nc >= N){
	            continue;
	        }
	        if(isVisited[nr][nc]){
	            continue;
	        }
	        int diff = Math.abs(map[nr][nc] - map[pos.r][pos.c]);
	        if(diff >= L && diff <= R){
	            isMoved = true;
	            sum += dfs(new Pos(nr, nc));
	        }
	        
	    }
	    return sum;
	}
	
	private static void move(int sum){
	    int avg = sum /poses.size();
	    for(Pos pos : poses){
	        map[pos.r][pos.c] = avg;
	    }
	    poses.clear();
	}
}
