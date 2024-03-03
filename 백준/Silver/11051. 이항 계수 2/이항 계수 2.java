import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 10007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }

        }

        System.out.println(dp[N][K]);
    }
}
