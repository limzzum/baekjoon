package silver1.P1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1149 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] cost = new int[N][3];
        for (int i=0; i<N; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                cost[i][j] = Math.min(cost[i-1][(j+1)%3], cost[i-1][(j+2)%3]) + cost[i][j];
            }
        }

        int answer = Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2]));
        System.out.println(answer);


    }
}
