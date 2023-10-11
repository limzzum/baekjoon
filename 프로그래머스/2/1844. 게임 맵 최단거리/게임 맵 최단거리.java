import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static boolean[][] isVisited;
    
    static class Character{
        int r;
        int c;
        int moveCnt;
        
        public Character(int r, int c, int moveCnt){
            this.r = r;
            this.c = c;
            this.moveCnt = moveCnt;
        }
    }
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        isVisited = new boolean[N][M];
        
        Queue<Character> qp = new ArrayDeque<>();
        qp.add(new Character(0,0,1));
        isVisited[0][0] = true;
        
        while(!qp.isEmpty()){
            Character character = qp.poll();
            
            for(int i = 0; i < 4; i++){
                int nr = character.r + row[i];
                int nc = character.c + col[i];
                
                if(nr<0 || nr>= N || nc<0 || nc>= M){
                    continue;
                }
                
                if(maps[nr][nc] == 0 || isVisited[nr][nc]){
                    continue;
                }
                
                if(nr == N - 1 && nc == M -1 ){
                    return character.moveCnt + 1;
                }
                isVisited[nr][nc] = true;
                qp.add(new Character(nr,nc, character.moveCnt + 1));
            }
            
        }
    
        

        return -1;
    }
}