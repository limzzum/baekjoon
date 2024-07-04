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
        
        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof Pos)){
                return false;
            }
            Pos pos = (Pos) obj;
            return pos.r == r && pos.c == c;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(r, c);
        }
    }
    
    static final String WORD = "MOLA";
    static final int[] row = {0, 1};
    static final int[] col = {1, 0};
    static int N;
    static char[][] map;
    static int[][] dp;
    static int startR;
    static int startC;
    static int maxCnt;
    static Map<Pos, List<Pos>> positionMap = new HashMap<>();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    map = new char[N][N];
	    dp = new int[N+1][N+1];
	    
	    for(int i=0; i<N; i++){
	        map[i] = br.readLine().toCharArray();
	    }
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<N; j++){
	            if(map[i][j] == 'M'){
	                startR = i;
	                startC = j;
	                countMola(0, i,j);
	            }
	        }
	    }
	    
	    for(int i=1; i<=N; i++){
	        for(int j=1; j<=N; j++){
	            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	            if(positionMap.containsKey(new Pos(i-1, j-1))){
	                for(Pos startPos : positionMap.get(new Pos(i-1,j-1))){
	                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[startPos.r+1][startPos.c]  + 1, dp[startPos.r][startPos.c+1] + 1));
	                }
	            }
	        }
	    }
	    
	    System.out.println(dp[N][N]);
	    
	}
	
	private static void countMola(int idx, int r, int c){
	    if(map[r][c] == WORD.charAt(idx)){
	        if(idx == 3){
	            positionMap.putIfAbsent(new Pos(r, c), new ArrayList<>());
	            positionMap.get(new Pos(r, c)).add(new Pos(startR, startC));
	            return;
	        }
	        for(int i=0; i<2; i++){
	            int nr = r + row[i];
	            int nc = c + col[i];
	            if(nr < 0 || nr >= N || nc < 0 || nc >= N){
	                continue;
	            }
	            countMola(idx +1, nr, nc);
	        }
	    }
	    
	}
	
}
