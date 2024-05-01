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
    static int N, M;
    static char[][] map;
    static Queue<Pos> queue = new ArrayDeque<>();
    static int r, c, R, C;
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        r = N;
        c = M;
        R = 0;
        C = 0;
        
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(map[i][j] == 'X'){
                    queue.add(new Pos(i, j));
                }
            }
        }
        
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            int cnt = 0;
            for(int i=0; i<4; i++){
                int nr = pos.r + row[i];
                int nc = pos.c + col[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '.'){
                    cnt += 1;
                }
            }
            if(cnt >= 3){
                map[pos.r][pos.c] = 'D';
                continue;
            }
            
            r = Math.min(r, pos.r);
            c = Math.min(c, pos.c);
            R = Math.max(R, pos.r);
            C = Math.max(C, pos.c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=r; i<=R; i++){
            for(int j=c; j<=C; j++){
                if(map[i][j] == 'X'){
                    sb.append('X');
                }else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
	}
}
