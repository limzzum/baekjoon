package silver1.P11660;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11660 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N+1][N+1];

        int sum = 0;
        for (int i=1; i<=N; i++){
            String[] line = br.readLine().split(" ");
            for (int j=1; j<=N; j++){
                sum += Integer.parseInt(line[j-1]);
                map[i][j] = sum;
            }
            if(i<N){
                map[i+1][0] = sum;
            }
        }

        int startX, startY, endX, endY;
        for (int i=0; i<M; i++){
            int result = 0;
            String[] position = br.readLine().split(" ");
            startX = Integer.parseInt(position[0]);
            startY = Integer.parseInt(position[1]);
            endX = Integer.parseInt(position[2]);
            endY = Integer.parseInt(position[3]);
            for(int j = startX; j<=endX; j++){
               result += map[j][endY] - map[j][startY-1];
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
