import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{

    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int N, M, K;
    static int startR, startC, endR, endC;
    static boolean[][] map;
    static List<Integer> widths = new ArrayList<>();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    map = new boolean[N][M];
	    
	    for(int i=0; i<K; i++){
	        st = new StringTokenizer(br.readLine());
	        startC = Integer.parseInt(st.nextToken());
	        endR = N - 1 - Integer.parseInt(st.nextToken());
	        endC = Integer.parseInt(st.nextToken()) - 1;
	        startR = N - Integer.parseInt(st.nextToken());
	        createRectangle();
	    }
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            if(!map[i][j]){
	               widths.add(dfs(i, j));
	            }
	        }
	    }
	    
	    String ans = widths.stream().sorted(Comparator.comparing(a -> a)).map(e -> e.toString()).collect(Collectors.joining(" "));
	    System.out.println(widths.size());
	    System.out.print(ans);
	}
	
    private static void createRectangle(){
        for(int i=startR; i<=endR; i++){
            for(int j= startC; j<=endC; j++){
                map[i][j] = true;
            }
        }
    }
    
    private static int dfs(int r, int c){
        map[r][c] = true;
        int cnt = 1;
        for(int i=0; i<4; i++){
            int nr = r + row[i];
            int nc = c + col[i];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                continue;
            }
            if(map[nr][nc]){
                continue;
            }
            cnt += dfs(nr, nc);
        }
        return cnt;
    }
	
}
