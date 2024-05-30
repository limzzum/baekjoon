import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    
    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int N;
    static char[][] map;
    static List<Integer> groupCnt = new ArrayList<>();
    static int cnt;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == '1'){
                    cnt = 0;
                    dfs(i, j);
                    groupCnt.add(cnt);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(groupCnt.size()).append("\n");
        groupCnt.stream().sorted(Comparator.comparing(a-> a)).forEach(a -> sb.append(a).append("\n"));
        System.out.print(sb);
        
	}
	
	private static void dfs(int r, int c){
	    map[r][c] = '0';
	    cnt += 1;
	    
	    for(int i=0; i<4; i++){
	        int nr = r + row[i];
	        int nc = c + col[i];
	        
	        if(nr < 0 || nr >= N || nc < 0 || nc >= N){
	            continue;
	        }
	        
	        if(map[nr][nc] == '1'){
	            dfs(nr, nc);
	        }
	    }
	}
}
