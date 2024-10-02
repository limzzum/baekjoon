import java.util.*;
import java.io.*;

public class Main{
    
    static class Pos{
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
	static int [][] map;
	static Queue<Pos> ices = new ArrayDeque<>();
	static boolean[][] isVisited;
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0){
                    ices.add(new Pos(i, j));
                }
            }
        }
        if(ices.size() == N*M){
            System.out.print(0);
            return;
        }
        
        int year = 0;
        Pos pos;
        int nr, nc;
        int cnt;
        int size = ices.size();
        while(size > 1){
            if(isBreak(size)){
                System.out.print(year);
                return;
            }
            year += 1;
            for(int i=0; i<size; i++){
                pos = ices.poll();
                cnt = 0;
             
                for(int j=0; j<4; j++){ 
                    nr = pos.r + row[j];
                    nc = pos.c + col[j];
                    if(nr >=0 && nr <N && nc >=0 && nc < M){
                        if(map[nr][nc] == 0 || (map[nr][nc] < 0 && map[nr][nc] != -year)){
                            cnt += 1;
                        }
                    }
                }
                int height = map[pos.r][pos.c] - cnt;
                if(height <=0){
                    map[pos.r][pos.c] = -year;
                }else{
                    map[pos.r][pos.c] = height;
                    ices.add(pos);
                }
            }
            size = ices.size();
        }
        
        System.out.print(0);
        
    }
    
    private static boolean isBreak(int size){
        Pos pos = ices.peek();
        isVisited = new boolean[N][M];
        return dfs(pos.r, pos.c) != size;
    }
    
    private static int dfs(int r, int c){
        int nr, nc;
        int cnt = 1;
        isVisited[r][c] = true;
        for(int i=0; i<4; i++){
            nr = r + row[i];
            nc = c + col[i];
            if(nr >=0 && nr <N && nc >=0 && nc <M){
                if(map[nr][nc] > 0 && !isVisited[nr][nc]){
                    cnt += dfs(nr, nc);
                }
            }
        }
        return cnt;
    }
   
}
