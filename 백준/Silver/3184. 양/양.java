import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static String[][] map;
    static boolean[][] visited;
    static int[] row ={0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static int R;
    static int C;
    static int yangCnt;
    static int wolfCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
         R = Integer.parseInt(input[0]);
         C = Integer.parseInt(input[1]);

        map = new String[R][C];
        visited = new boolean[R][C];
        for (int i=0; i<R; i++){
            map[i] = br.readLine().split("");
        }

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if(!(map[i][j].equals("#")) && !visited[i][j]){
                    bfs(i,j);
                }
            }
        }
        System.out.println(yangCnt+" "+wolfCnt);
    }
    private static void bfs(int r, int c){
        Queue<int[]> qp = new ArrayDeque<>();
        qp.add(new int[]{r,c});
        visited[r][c] = true;
        int v=0;
        int o=0;
        while (!qp.isEmpty()){
            int[] poll = qp.poll();
            int curR = poll[0];
            int curC = poll[1];
            if(map[curR][curC].equals("v")){
                v+=1;
            }if(map[curR][curC].equals("o")){
                o+=1;
            }

            for (int i=0; i<4; i++){
                int nexR = curR+row[i];
                int nexC = curC+col[i];
                if(nexR>=0 && nexR<R && nexC>=0 && nexC<C){
                    if(!visited[nexR][nexC] && !(map[nexR][nexC].equals("#"))){
                        visited[nexR][nexC]= true;
                        qp.add(new int[]{nexR,nexC});
                    }
                }
            }

        }
        if(o>v){
            yangCnt += o;
        }else{
            wolfCnt += v;
        }
    }
}
