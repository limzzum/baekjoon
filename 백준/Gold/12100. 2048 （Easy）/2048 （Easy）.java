import java.util.*;
import java.io.*;

public class Main{
    
    static class Game{
        String state;
        int cnt;
        
        public Game(String state, int cnt){
            this.state = state;
            this.cnt = cnt;
        }
    }
    
    static final Map<Integer, Character> map = new HashMap<>(){{
        put(0, 'E');
        put(2, 'b');
        put(4, 'c');
        put(8, 'd');
        put(16, 'e');
        put(32, 'f');
        put(64, 'g');
        put(128, 'h');
        put(256, 'i');
        put(512, 'j');
        put(1024, 'k');
    }};
    
    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int N;
    static int answer;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());

	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                sb.append(map.get(n));
                answer = Math.max(answer, n);
            }
	    }
	    dfs(new Game(sb.toString(), 0));
	    System.out.print(answer);
	}
	
	private static void dfs(Game game){
	    if(game.cnt == 5){
	        return;
	    }
	    for(int i=0; i<4; i++){
	        dfs(new Game(move(game.state, i), game.cnt + 1));
	    }
	}
	
	private static String move(String state, int direction){
	    int startR;
	    int startC;
	    int R, C;
	    
	    char[] board = state.toCharArray();
	    boolean[] isVisited = new boolean[board.length];
	    if(direction %2 == 0){
	        if(direction == 0){
	            C = 0;
	        }else {
	            C = N -1;
	        }
	        
	       for(int i=0; i<N; i++){
	           startC = C;
	           for(int j=1; j<N; j++){
	               startC -= col[direction];
	               if(board[i*N+startC] == 'E'){
	                   continue;
	               }
	               int next = startC;
	               while(true){
	                   next += col[direction];
                        if(next < 0 || next == N){
                            next -= col[direction];
	                        break;
                        }
	                   if(!isVisited[i * N + next]){
	                       if(board[i * N + next] == board[i * N + startC]){
	                       break;
	                   }

	                       if(board[i * N +next] == 'E'){
	                            continue;
	                       }
	                   }
	                   next -= col[direction];
	                   break;
	               }
	               if(next != startC){
	                   if(board[i * N + next] == 'E'){
	                           board[i * N + next] = board[i * N + startC];
	                           board[i * N +startC] = 'E';
	                   }else{
	                       isVisited[i*N + next] = true;
	                       board[i * N +next] += 1;
	                       board[i * N +startC] = 'E';
	                       answer = Math.max(answer, (int) Math.pow(2,board[i * N +next]-'a'));
	                   }
	               }
	           }
	       }
	        
	    }else {
	        if(direction == 1){
	            R = 0;
	        }else {
	            R = N-1;
	        }
	       for(int i=0; i<N; i++){
	           startR = R;
	           for(int j=1; j<N; j++){
	               startR -= row[direction];
	               if(board[startR * N + i] == 'E'){
	                   continue;
	               }
	               int next = startR;
	               while(true){
	                   next += row[direction];
	                   if(next < 0 || next == N){
                            next -= row[direction];
	                        break;
                        }
	                   if(!isVisited[next * N + i]){
	                       if(board[next * N + i] == board[startR * N + i]){
	                       break;
	                   }
	                       if(board[next * N +i] == 'E'){
	                            continue;
	                       }
	                   }
	                   next -= row[direction];
	                   break;
	               }
	               if(next != startR){
	                     if(board[next * N + i] == 'E'){
	                           board[next * N +i] = board[startR * N + i];
	                           board[startR * N +i] = 'E';
	                       
	                   }else{
	                       isVisited[next * N +i] = true;
	                       board[next * N +i] += 1;
	                       board[startR * N +i] = 'E';
	                       answer = Math.max(answer, (int) Math.pow(2,board[next * N +i]-'a'));
	                   }
	               }
	           }
	       }
	    }
	    return String.valueOf(board);
	}
	
}
