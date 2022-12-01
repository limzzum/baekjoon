package silver1.P2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2178 {

    public static class Node{
        int r;
        int c;
        int count;
        public Node(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> qp = new LinkedList<>();

        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        boolean[][] visited = new boolean[N+1][M+1];

        int [][] map = new int[N+1][M+1];
        int [] row = {0,-1,0,1};
        int [] col = {-1,0,1,0};

        for(int i=1; i<N+1; i++){
            String[] line = br.readLine().split("");
            for(int j=1; j<M+1; j++){
                map[i][j] = Integer.parseInt(line[j-1]);
            }
        }

        qp.add(new Node(1,1,1));

        while(!qp.isEmpty()){
            Node node = qp.poll();
            for(int i=0; i<4; i++){
                int R = node.r+row[i];
                int C = node.c+col[i];

                if(R == N && C == M){
                    System.out.println(node.count+1);
                    return;
                }
                if(R>0 && R<N+1 && C>0 && C<M+1){
                    if(!visited[R][C] && map[R][C] == 1){
                        qp.add(new Node(R,C,node.count+1));
                        visited[R][C] = true;
                    }
                }
            }
        }
    }
}
