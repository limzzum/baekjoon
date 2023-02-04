import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    
    static int [] row = {0,-1,0,1};
    static int [] col = {-1,0,1,0};
    static int answer;
    static int N;
    static int M;
    static int[][] map;
    static int[][] visit;
    
    static class Node{
        int r;
        int c;
        int cnt;
        int chance;
        public Node(int r, int c, int cnt, int chance){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.chance = chance;
        }
    }
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> qp = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        if(N==1 && M ==1){
            System.out.println(1);
            return;
        }
        map = new int[N][M];
        visit = new int[N][M];
        answer = N*M+1;
        for(int i=0; i<N; i++){
            String[] line = br.readLine().split("");
            for(int j= 0;j<M; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        qp.add(new Node(0,0,1,1));
        visit[0][0] = 2;
        while (!qp.isEmpty()){
            Node node = qp.poll();
            for(int i=0; i<4; i++){
                int nexR = node.r+row[i];
                int nexC = node.c+col[i];
                if(nexR == N-1 && nexC == M-1){
                    System.out.println(node.cnt+1);
                    return;
                }
                if(nexR>=0 && nexR<N && nexC >=0 && nexC<M && !(visit[nexR][nexC]==2)){
                    if(map[nexR][nexC] == 0){
                        if(node.chance ==1){
                            visit[nexR][nexC] = 2;
                            qp.add(new Node(nexR, nexC, node.cnt+1,node.chance));
                        }
                        if(node.chance == 0 && visit[nexR][nexC]==0){
                            visit[nexR][nexC] = 1;
                            qp.add(new Node(nexR, nexC, node.cnt+1,node.chance));
                        }

                    }else if(node.chance == 1){
                        visit[nexR][nexC] = 2;
                        qp.add(new Node(nexR,nexC,node.cnt+1, 0));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}