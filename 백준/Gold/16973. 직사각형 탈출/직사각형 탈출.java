import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[] row = {0,-1,0,1};
    static int[] col = {-1, 0, 1, 0};

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
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> qp = new ArrayDeque<>();
        String [] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int [][] map = new int[N][M];
        boolean [][] visited = new boolean[N][M];
        List<int[]> barriers = new ArrayList<>();

        for(int i=0; i<N; i++){
            String [] line = br.readLine().split(" ");
            for (int j=0; j<M; j++){
                if(Integer.parseInt(line[j])==1){
                    map[i][j] = Integer.parseInt(line[j]);
                    barriers.add(new int[]{i,j});
                }
            }
        }
        String [] data = br.readLine().split(" ");

        int h = Integer.parseInt(data[0]);
        int w = Integer.parseInt(data[1]);
        int startR = Integer.parseInt(data[2])-1;
        int startC = Integer.parseInt(data[3])-1;
        int endR = Integer.parseInt(data[4])-1;
        int endC = Integer.parseInt(data[5])-1;

        for(int[] barrier: barriers){

            int minR = Math.max(0, barrier[0] - h +1);
            int minC = Math.max(0, barrier[1] - w +1);
            for(int i=barrier[0]; i>= minR; i--){
                map[i][barrier[1]] = 1;
                map[i][minC] = 1;
            }

            for(int i=barrier[1]; i>= minC; i--){
                map[barrier[0]][i] = 1;
                map[minR][i] = 1;
            }

        }

        qp.add(new Node(startR,startC,0));
        visited[startR][startC] = true;
        while (!qp.isEmpty()){
            Node poll = qp.poll();
            int curR = poll.r;
            int curC = poll.c;
           // System.out.println("curR : "+curR + " curC : "+curC);
            for (int i=0; i<4; i++){
                int nexR = curR+row[i];
                int nexC = curC+col[i];
                if(nexR == endR && nexC ==endC){
                    System.out.println(poll.cnt+1);
                    return;
                }

                if(nexR>=0 && nexR<N-h+1 && nexC>=0 && nexC<M-w+1){
                    if(!visited[nexR][nexC] && map[nexR][nexC] ==0){
                        visited[nexR][nexC] =true;
                        qp.add(new Node(nexR,nexC, poll.cnt+1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
