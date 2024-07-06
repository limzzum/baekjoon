import java.util.*;
import java.io.*;

public class Main{

    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int R, C;
    static int[][] map = new int[5][5];
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st;
	    for(int i=0; i<5; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<5; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    
	    if(dfs(R, C, 0, 0)){
	        System.out.print(1);
	        return;
	    }
	    System.out.print(0);
	    
	}
	private static boolean dfs(int r, int c, int cnt, int apple){
	    if(map[r][c] == 1){
	        apple += 1;
	        if(apple == 2){
	            return true;
	        }
	    }
	    if(cnt == 3){
	        return false;
	    }
	    
	    map[r][c] = -1;
	    for(int i=0; i<4; i++){
	        int nr = r + row[i];
	        int nc = c + col[i];
	        
	        if(nr <0 || nr >= 5 || nc < 0 || nc >= 5){
	            continue;
	        }
	        if(map[nr][nc] == -1){
	            continue;
	        }
	        
	        int temp = map[nr][nc];
	        if(dfs(nr, nc, cnt + 1, apple)){
	            return true;
	        }
	        map[nr][nc] = temp;
	    }
	    return false;
	}
 	
}
