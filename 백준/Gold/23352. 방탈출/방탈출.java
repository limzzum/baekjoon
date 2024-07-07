import java.util.*;
import java.io.*;

public class Main{

    static class Node {
        int r;
        int c;
        int distance;
        public Node(int r, int c, int distance){
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }
    
    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int maxDistance = 1;
    static int answer;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Queue<Node> queue = new ArrayDeque<>();
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    map = new int[N][M];
	    
	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<M; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	            answer = Math.max(answer, map[i][j]);
	        }
	    }
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            if(map[i][j] == 0){
	                continue;
	            }
	            queue.add(new Node(i, j, 1));
	            isVisited = new boolean[N][M];
	            isVisited[i][j] = true;
	            while(!queue.isEmpty()){
	                Node node = queue.poll();
	                if(node.distance >= maxDistance){
	                    if(node.distance > maxDistance){
	                        maxDistance = node.distance;
	                        answer = map[i][j] + map[node.r][node.c];
	                    }else {
	                        answer = Math.max(answer, map[i][j] + map[node.r][node.c]);
	                    }
	                }
	                
	                for(int k=0; k<4; k++){
	                    int nr = node.r + row[k];
	                    int nc = node.c + col[k];
	                    
	                    if(nr < 0 || nr >=N || nc < 0 || nc >=M){
	                        continue;
	                    }
	                    
	                    if(isVisited[nr][nc] || map[nr][nc] == 0){
	                        continue;
	                    }
	                    isVisited[nr][nc] = true;
	                    queue.add(new Node(nr, nc, node.distance + 1));
	                }
	            }
	        }
	    }
	    
	    System.out.print(answer);
	    
	}
	
}
