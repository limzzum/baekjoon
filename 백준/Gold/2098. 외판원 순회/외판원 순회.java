import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//곽멘
public class Main {

    static int N;
    static int[][] dist;
    static int[][] dp;
    static final int INF = 10_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];
        dp = new int[N][(1<<N) - 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1);

        System.out.println(dp[0][1]);
    }

    private static int dfs(int cur, int visited) {

        if (visited == ((1<<N) -1)) {
            if(dist[cur][0] == 0){
                return INF;
            }
            return dist[cur][0];
        }
        if(dp[cur][visited] != 0){
            return dp[cur][visited];
        }
        dp[cur][visited] = INF;

        for (int i = 1; i < N; i++) {
            if (((1 << i) & visited) == 0 && dist[cur][i] != 0) {
                int nVisited = visited | (1 << i);
                dp[cur][visited] = Math.min(dp[cur][visited], dist[cur][i] + dfs(i, nVisited));
            }
        }
        return dp[cur][visited];

    }

}
