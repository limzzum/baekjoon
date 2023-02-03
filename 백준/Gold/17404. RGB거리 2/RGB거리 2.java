import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int [][] cost = new int[N+1][3];
        for(int i=1; i<=N; i++){
            String [] line = br.readLine().split(" ");
            for(int j= 0; j<line.length; j++){
                cost[i][j] = Integer.parseInt(line[j]);
            }
        }
        if(N==2){
            for(int j= 0; j<3; j++){
                int a = (j+1)%3;
                int b = (j+2)%3;
                cost[N][j] += Math.min(cost[1][a], cost[1][b]);
            }
            System.out.println(Math.min(cost[N][0], Math.min(cost[N][1], cost[N][2])));
            return;
        }
        int answer = Integer.MAX_VALUE;


        for(int i=0; i<3; i++){
            answer = Math.min(answer, getCost(cost, i));
        }

        System.out.println(answer);

    }

    private static int getCost(int[][] Cost, int order){
        int [][] cost = new int[Cost.length][Cost[0].length];
        cost[2][0] = Cost[2][0] + Cost[1][order];
        cost[2][1] = Cost[2][1] + Cost[1][order];
        cost[2][2] = Cost[2][2] + Cost[1][order];
        cost[2][order] = Integer.MAX_VALUE;
        for(int i=3; i<=N; i++) {
            for(int j= 0; j<3; j++){
                int a = (j+1)%3;
                int b = (j+2)%3;
                if(i==N && j == order){
                    cost[i][j] = Integer.MAX_VALUE;
                }else {
                    cost[i][j] = Cost[i][j] + Math.min(cost[i - 1][a], cost[i - 1][b]);
                }

            }

        }

        int result =  Math.min(cost[N][0], Math.min(cost[N][1], cost[N][2]));
        return result;
    }
}
