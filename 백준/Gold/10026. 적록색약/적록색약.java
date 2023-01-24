import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] Row = {0,-1,0,1};
    static int[] Col = {-1,0,1,0};
    static boolean[][] visited;
    static String [][] map;
    static Queue<int[]> qp = new LinkedList<>();

    static Map<String, String> eachMap = Map.of("R","G","G","R","B","B");
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new String[N][N];

        for(int i=0; i<N; i++){
            String[] line = br.readLine().split("");
            for (int j= 0; j<N; j++){
                qp.add(new int[]{i,j});
                map[i][j] = line[j];
            }
        }
        visited = new boolean[N][N];
        Queue<int[]> qp1 = new LinkedList<>(qp);
        int count = 0;
        while (!qp.isEmpty()){
            int[] poll = qp.poll();
            if(visited[poll[0]][poll[1]]){
                continue;
            }
            count +=1;
            visit(poll[0], poll[1], map[poll[0]][poll[1]]);
        }
        sb.append(count).append(" ");
        qp= qp1;
        count = 0;
        visited = new boolean[N][N];
        while (!qp.isEmpty()){
            int[] poll = qp.poll();
            if(visited[poll[0]][poll[1]]){
                continue;
            }
            count +=1;
            visit2(poll[0], poll[1], map[poll[0]][poll[1]]);
        }
        sb.append(count);
        System.out.println(sb);
    }

    private static void visit(int r, int c, String color){

            for(int i=0; i<4; i++){
                int row = r+Row[i];
                int col = c+Col[i];
                if(row>=0 && row<N && col >=0 && col<N){
                    if(map[row][col].equals(color)  && !visited[row][col]){
                        visited[row][col] = true;
                        visit(row,col,color);
                    }
                }
            }

    }
    private static void visit2(int r, int c, String color){

        for(int i=0; i<4; i++){
            int row = r+Row[i];
            int col = c+Col[i];
            if(row>=0 && row<N && col >=0 && col<N){
                if((map[row][col].equals(color) || eachMap.get(map[row][col]).equals(color))&& !visited[row][col]){
                    visited[row][col] = true;
                    visit2(row,col,color);
                }
            }
        }

    }
}
