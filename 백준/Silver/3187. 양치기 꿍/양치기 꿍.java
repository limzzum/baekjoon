import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main{

    static int [] row = {0,-1,0,1};
    static int [] col = {-1,0,1,0};
    static int answer;
    static int N;
    static int M;
    static String[][] map;
    static boolean[][] visited;
    static int saveY = 0;
    static int saveW = 0;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> qp = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new String[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N;i++){
            String [] line = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = line[j];
                if(map[i][j].equals("v")){
                    qp.add(new int[]{i,j});
                }
                if(map[i][j].equals("k")){
                    qp.add(new int[]{i,j});
                }
            }
        }

        while(!qp.isEmpty()){
            int[] poll = qp.poll();
            int r = poll[0];
            int c = poll[1];
            if(visited[poll[0]][poll[1]]){
                continue;
            }
            if(map[r][c].equals("v")){
                wCnt +=1;
            }
            if(map[r][c].equals("k")){
                yCnt +=1;
            }
            visited[r][c] = true;
            dfs(r,c);
            if(yCnt>wCnt){
                saveY += yCnt;
            }else{
                saveW += wCnt;
            }
            yCnt = 0;
            wCnt = 0;
        }
        System.out.println(saveY +" "+saveW);

    }
    static int yCnt = 0;
    static int wCnt = 0;
    private static void dfs(int r, int c) {
        for(int i=0; i<4; i++){
            int nexR = r + row[i];
            int nexC = c + col[i];
            if(nexR>=0 && nexR <N && nexC>=0 && nexC <M && !visited[nexR][nexC]){
                visited[nexR][nexC]= true;
                if(!map[nexR][nexC].equals("#")){
                    if(map[nexR][nexC].equals("v")){
                        wCnt +=1;
                    }
                    else if(map[nexR][nexC].equals("k")){
                        yCnt +=1;
                    }
                    dfs(nexR,nexC);
                }
            }
        }
    }
}