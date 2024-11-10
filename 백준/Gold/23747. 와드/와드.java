import java.util.*;
import java.io.*;

public class Main{
    
    static class Pos{
        
        static final String DIRECTION = "LURD";
        static final int[] row = {0, -1, 0, 1};
        static final int[] col = {-1, 0, 1, 0};
        
        int r;
        int c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        public void move(String direction){
            if(direction.equals("W")){
                light(r, c, map[r][c]);
            }else {
                r += row[DIRECTION.indexOf(direction)];
                c += col[DIRECTION.indexOf(direction)];
            }
        }
        
        public void finish(){
            int nr, nc;
            map[r][c] = '.';
            for(int i=0; i<4; i++){
                nr = r + row[i];
                nc = c + col[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                    continue;
                }
                map[nr][nc] = '.';
            }
        }
        private void light(int r, int c, char area){
            map[r][c] = '.';
            int nr, nc;
            for(int i=0; i<4; i++){
                nr = r + row[i];
                nc = c + col[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                    continue;
                }
                if(map[nr][nc] == '.' || map[nr][nc] != area){
                    continue;
                }
                light(nr, nc, area);
            }
        }
    }
    
    static int N, M;
    static char[][] map;
    static Pos oneStar;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    map = new char[N][M];
	    
	    for(int i=0; i<N; i++){
	        map[i] = br.readLine().toCharArray();
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    oneStar = new Pos(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
	    
	    char[] commands = br.readLine().toCharArray();
	    for(char command : commands){
	        oneStar.move(String.valueOf(command));
	    }
	    oneStar.finish();
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            if(map[i][j] != '.'){
	                map[i][j] = '#';
	            }
	            sb.append(map[i][j]);
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	}
}
