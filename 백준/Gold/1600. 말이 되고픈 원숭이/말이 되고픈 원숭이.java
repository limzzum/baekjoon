import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main{

    static int [] row = {0,1,0,-1};
    static int [] col = {1,0,-1,0};
    static int [] moveDiagonalR = {-1,-2,-2,-1,1,2,2,1};
    static int [] moveDiagonalC = {-2,-1,1,2,2,1,-1,-2};
    static int answer;
    static int N;
    static int M;
    static int[][] map;
    static int[][] visit;
    static int [][] have;
    static int[][] count;

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

        int K = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[0]);
        if(N==1 && M ==1){
            System.out.println(0);
            return;
        }
        map = new int[N][M];
        visit = new int[N][M];
        have = new int[N][M];
        count = new int[N][M];
        answer = N*M+1;
        for(int i=0; i<N;i++){
            for (int j=0; j<M;j++){
                count[i][j] = answer;
                have[i][j] = -1;
            }
        }
        for(int i=0; i<N; i++){
            String[] line = br.readLine().split(" ");
            for(int j= 0;j<M; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        qp.add(new Node(0,0,0,K));
        visit[0][0] = 2;
        count[0][0] = answer;
        
        while (!qp.isEmpty()){
            Node node = qp.poll();
        
            if(node.chance>0) {
                for(int i=0; i<8; i++) {
                    int nexR = node.r+moveDiagonalR[i];
                    int nexC = node.c+moveDiagonalC[i];
                    if(nexR == N-1 && nexC == M-1){
                        answer = Math.min(answer, node.cnt+1);
                        System.out.println(answer);
                        return;
                    }
                    if(nexR>=0 && nexR<N && nexC >=0 && nexC<M ){
                        if(map[nexR][nexC] == 0 && node.chance-1 > have[nexR][nexC] ){
                            visit[nexR][nexC] = 2;
                            count[nexR][nexC]=node.cnt+1;
                            have[nexR][nexC] = node.chance-1;
                            qp.add(new Node(nexR, nexC, node.cnt+1,node.chance-1));
                        }
                    }
                }
            }
            for(int i=0; i<4; i++){
                int nexR = node.r+row[i];
                int nexC = node.c+col[i];
                if(nexR == N-1 && nexC == M-1){
                    answer = Math.min(answer, node.cnt+1);
                    System.out.println(answer);
                    return;
                }
                if(nexR>=0 && nexR<N && nexC >=0 && nexC<M ){
                    if(map[nexR][nexC] == 0 && node.chance> have[nexR][nexC] ){
                        visit[nexR][nexC] = 1;
                        count[nexR][nexC]= node.cnt+1;
                        have[nexR][nexC] = node.chance;
                        qp.add(new Node(nexR, nexC, node.cnt+1,node.chance));

                    }
                }
            }
        }
        System.out.println(-1);
    }
}