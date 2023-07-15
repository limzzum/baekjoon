import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    static int[][] dp;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0) {
                    dfs(i, j, 1, 0);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.println(ans);
    }

    private static int dfs(int r, int c, int cnt , int depth) {
        int result = cnt;
        for (int i = 0; i < 4; i++) {
            int nr = r + row[i];
            int nc = c + col[i];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue;
            }
            if (map[nr][nc] <= map[r][c]) {
                continue;
            }
            if (dp[nr][nc] > 0) {
                result = Math.max(result, cnt + dp[nr][nc]);
                continue;
            }
            int maxReturn = dfs(nr, nc, cnt + 1, depth +1);
            dp[r][c] = Math.max(dp[r][c], maxReturn - depth);
            result = Math.max(result, maxReturn);
        }

        dp[r][c] = Math.max(dp[r][c], result - depth);
        return result;
    }
}
