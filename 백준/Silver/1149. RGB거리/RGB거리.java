import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] cost = new int[N+1][3];
        for(int i=1; i<=N; i++){
            String [] line = br.readLine().split(" ");
            for(int j= 0; j<line.length; j++){
                int a = (j+1)%3;
                int b = (j+2)%3;
                cost[i][j] = Math.min(cost[i-1][a], cost[i-1][b]) + Integer.parseInt(line[j]);
            }
        }
        int answer = Math.min(cost[N][0], Math.min(cost[N][1], cost[N][2]));
        System.out.println(answer);

    }
}
