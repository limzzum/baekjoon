package silver1.P2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {
    static int N;
    static int [][] map;
    static int [] row = {0, -1, 0, 1};
    static int [] col = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> qp = new LinkedList<>();
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i<N; i++){
            String[] line = br.readLine().split("");
            for(int j = 0; j<N; j++){
                int num = Integer.parseInt(line[j]);
                if(num == 1){
                    map[i][j] = num;
                    qp.add(new int[]{i,j});
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        while(!qp.isEmpty()){
            int count = 1;
            int[] position = qp.poll();
            if(map[position[0]][position[1]]== 1) {
                map[position[0]][position[1]]=0;
                count = dfs( count, position);
                answer.add(count);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    private static int dfs( int count, int[] position) {
        for (int i=0; i<4; i++){
            int r = position[0]+ row[i];
            int c = position[1]+ col[i];
            if(r>=0 && r< N && c>=0 && c< N){
                if(map[r][c]==1){
                    count += 1;
                    map[r][c] = 0;
                    count = dfs(count, new int[]{r,c});
                }
            }
        }
        return count;
    }
}
