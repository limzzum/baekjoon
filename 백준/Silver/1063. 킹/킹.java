import java.util.*;
import java.io.*;

public class Main{
    
    static class Map{
        static final int[] row = {0, -1, -1, -1, 0, 1, 1, 1};
        static final int[] col = {-1, -1, 0, 1, 1, 1, 0, -1};
        static final String[] directions = {"L", "LT", "T", "RT", "R", "RB", "B", "LB"};
        
        int [][] board;
        int curR;
        int curC;
        int stoneR;
        int stoneC;
        static final String colIdx = "ABCDEFGH";
        
        public Map(String start, String stone){
            board = new int[8][8];
            init(start, stone);
        }
        
        public void init(String position, String stone){
            curR = 8- (position.charAt(1) - '0');
            curC = colIdx.indexOf(position.charAt(0));
            stoneR = 8- (stone.charAt(1) -'0');
            stoneC = colIdx.indexOf(stone.charAt(0));
        }
        
        public void move(String command){
            int idx = getIdx(command);
            int nr = curR + row[idx];
            int nc = curC + col[idx];
            if(!isIn(nr, nc)){
                return;
            }
            if(nr == stoneR && nc == stoneC && !isIn(nr+row[idx], nc + col[idx])){
                return;
            }
            if(nr == stoneR && nc == stoneC){
                stoneR = nr + row[idx];
                stoneC = nc + col[idx];
            }
            curR = nr;
            curC = nc;
        }
        
        public void printCurPos(){
            System.out.println(colIdx.charAt(curC)+""+(8 - curR));
            System.out.print(colIdx.charAt(stoneC)+""+(8 - stoneR));
        }
        
        private int getIdx(String command){
            int idx = 0;
            for(String dir : directions){
                if(command.equals(dir)){
                    return idx;
                }
                idx += 1;
            }
            return idx;
        }
        
        private boolean isIn(int r, int c){
            if(r < 0 || r >= 8 || c < 0 || c >= 8){
                return false;
            }
            return true;
        }
        
        
    }
    
    static int N;
    static Map map;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    map = new Map(st.nextToken(), st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        String move;
        for(int i=0; i<N; i++){
            move = br.readLine();
            map.move(move);
        }
        map.printCurPos();
	}

}
