package silver1.P2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2468 {
    static int N;
    static int[][] newMap;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> qp = new LinkedList<>();
        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        newMap = new int[N][N];
        int min = 100;
        int max = 0;
        for (int i=0; i<N; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                int heigth = Integer.parseInt(line[j]);
                map[i][j] = heigth;
                if(heigth>max){
                    max = heigth;
                }
                if(heigth<min){
                    min = heigth;
                }
            }
        }

        int answer = 0;
        for (int x=min-1; x<=max; x++){

            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    newMap[i][j] = map[i][j];
                }
            }

            for (int i = 0; i<N; i++){
                for (int j = 0; j<N; j++){
                    if(newMap[i][j]>x){
                        qp.add(new int[]{i,j});
                    }
                }
            }
            int count = 0;

            while (!qp.isEmpty()){
                int[] poll = qp.poll();
                if(newMap[poll[0]][poll[1]]<=x){
                    continue;
                }
                count +=1;
                dfs(x, poll);
            }
            answer = Math.max(answer, count);

        }
        System.out.println(answer);
    }

    private static void dfs(int x, int[] poll) {
        for (int i= 0; i<4; i++){
            if(poll[0]+row[i]>=0 && poll[0]+row[i]<N && poll[1]+col[i]>=0 && poll[1]+col[i]<N){
                if(newMap[poll[0]+row[i]][poll[1]+col[i]]> x){
                    newMap[poll[0]+row[i]][poll[1]+col[i]] = x;
                    dfs(x, new int[]{poll[0]+row[i],poll[1]+col[i]});
                }
            }
        }
    }
}
