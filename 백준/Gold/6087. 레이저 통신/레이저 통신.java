import java.util.*;
import java.io.*;

public class Main{

    static class Node{
        int r;
        int c;
        int dir;
        int cnt;
        
        public Node(int r, int c, int dir, int cnt){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    
    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};
    static int N, M;
    static char[][] map;
    static Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> a.cnt));
    static List<int[]> target = new ArrayList<>();
    static int[][][] count;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        count = new int[N][M][5];
        
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(map[i][j] == 'C'){
                    target.add(new int[]{i,j});
                }
                for(int k=0; k<4; k++){
                    count[i][j][k] = M*N;
                }
            }
        }
        
        pq.add(new Node(target.get(0)[0], target.get(0)[1], 4, -1));
        
        Node node;
        int nr, nc, ncnt;
        while(!pq.isEmpty()){
            node = pq.poll();
            if(node.cnt >= count[node.r][node.c][node.dir]){
                continue;
            }
            
            count[node.r][node.c][node.dir] = node.cnt;
            if(node.r == target.get(1)[0] && node.c == target.get(1)[1]){
                System.out.println(node.cnt);
                return;
            }
            for(int i=0; i<4; i++){
                nr = node.r + row[i];
                nc = node.c + col[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                    continue;
                }
                if(map[nr][nc] == '*'){
                    continue;
                }
                ncnt = node.cnt;
                if(node.dir != i){
                    ncnt += 1;
                }

                if(count[nr][nc][i] <= ncnt){
                    continue;
                }
                
                pq.add(new Node(nr, nc, i, ncnt));
            }
        }
	}
}
