import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int K;
    static List<int[]> bags = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        int[][] dp = new int[N+1][K+1];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int weight = Integer.parseInt(line[0]);
            int value = Integer.parseInt(line[1]);

            bags.add(new int[]{weight, value});
        }

        for (int i = 1; i <= N; i++){
            for(int j=1; j <= K; j++){
                dp[i][j]= dp[i-1][j];
                if(bags.get(i-1)[0] > j){
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-bags.get(i-1)[0]]+bags.get(i-1)[1]);
            }
        }
        System.out.println(dp[N][K]);
    }

}