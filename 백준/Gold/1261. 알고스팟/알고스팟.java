import java.util.*;
import java.io.*;

public class Main{
    
    static class Node{
        int r;
        int c;
        int cnt;
        public Node(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int N, M;
    static char[][] map;
    static boolean[][] isVisited;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(a -> a.cnt));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        if(N == 1 && M == 1){
            System.out.print(0);
            return;
        }
        
        map = new char[N][M];
        isVisited = new boolean[N][M];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }
        
        isVisited[0][0] = true;
        queue.add(new Node(0,0,0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                int nr = node.r + row[i];
                int nc = node.c + col[i];
                
                if(nr >= N || nr < 0 || nc >= M || nc < 0){
                    continue;
                }
                
                if(isVisited[nr][nc]){
                    continue;
                }
                
                isVisited[nr][nc] = true;
                if(nr == N -1 && nc == M -1){
                    System.out.print(node.cnt);
                    return;
                }
                
                if(map[nr][nc] == '1'){
                    queue.add(new Node(nr, nc, node.cnt + 1));
                }else {
                    queue.add(new Node(nr, nc, node.cnt));
                }
            }
        }
        
	}
}
