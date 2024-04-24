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
    
    static class Status{
        Pos redBall;
        Pos blueBall;
        int cnt;
        public Status(Pos redBall, Pos blueBall, int cnt){
            this.redBall = redBall;
            this.blueBall = blueBall;
            this.cnt = cnt;
        }
    }
    
    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int N, M;
    static char[][] map;
    static boolean[][][][] isVisited;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Queue<Status> queue = new ArrayDeque();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isVisited = new boolean[N][M][N][M];
        
        Status start = new Status(null, null, 0);
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(map[i][j] == 'R'){
                    start.redBall = new Pos(i,j);
                }else if(map[i][j] == 'B'){
                    start.blueBall = new Pos(i,j);
                }
            }
        }
        isVisited[start.redBall.r][start.redBall.c][start.blueBall.r][start.blueBall.c] = true;
        queue.add(start);
        
        while(!queue.isEmpty()){
            Status status = queue.poll();
            
            for(int i=0; i<4; i++){
                Pos nextRedBall = find(status.redBall, i);
                Pos nextBlueBall = find(status.blueBall, i);

                if(map[nextBlueBall.r][nextBlueBall.c] == 'O'){
                        continue;
                }
                if(map[nextRedBall.r][nextRedBall.c] == 'O'){
                    System.out.println(status.cnt + 1);
                    return;
                }
                if(status.cnt == 9){
                    continue;
                }
                if(nextRedBall.r == nextBlueBall.r && nextRedBall.c == nextBlueBall.c){
                   
                    if(isRedFirst(status.redBall, status.blueBall, i)){
                        nextBlueBall.r -= row[i];
                        nextBlueBall.c -= col[i];
                    }else{
                        nextRedBall.r -= row[i];
                        nextRedBall.c -= col[i];
                    }
                }
                
                if(isVisited[nextRedBall.r][nextRedBall.c][nextBlueBall.r][nextBlueBall.c]){
                    continue;
                }
                isVisited[nextRedBall.r][nextRedBall.c][nextBlueBall.r][nextBlueBall.c] = true;
                queue.add(new Status(nextRedBall, nextBlueBall, status.cnt +1));
                
            }
        }
        
        System.out.println(-1);
	}
	
	private static Pos find(Pos start, int direction){
	    Pos nextPos = new Pos(start.r, start.c);
	    while(true){
	        if(map[nextPos.r + row[direction]][nextPos.c + col[direction]] == '#'){
	            return nextPos;
	        }
	        nextPos.r += row[direction];
	        nextPos.c += col[direction];
	        if(map[nextPos.r][nextPos.c] == 'O'){
	            return nextPos;
	        }
	    }
	}
	private static boolean isRedFirst(Pos a, Pos b, int direction){
	    if(direction == 0){
	        if(a.c < b.c){
	            return true;
	        }
	    }else if(direction == 1){
	        if(a.r < b.r){
	            return true;
	        }
	    }else if(direction == 2){
	        if(a.c > b.c){
	            return true;
	        }
	    }else if(direction == 3){
	        if(a.r > b.r){
	            return true;
	        }
	    }
	    
	    return false;
	}

}
