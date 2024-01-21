import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int R,C;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static int[][] map;
    static boolean[][] isVisited;
    static boolean[][] isVisitedHard;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        dp = new int[R][C];
        isVisited = new boolean[R][C];
        isVisitedHard = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isVisited[0][0] = true;
        dp[R-1][C-1] = 1;
        dfs(0,0);
        System.out.println(dp[0][0]);


    }

    private static int dfs(int r, int c){

        for (int i = 0; i < 4; i++) {
            int nr = r + row[i];
            int nc = c + col[i];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C){
                continue;
            }
            if(isVisited[nr][nc]){
                continue;
            }
            if(map[nr][nc] < map[r][c]){
                if(isVisitedHard[nr][nc]){
                    dp[r][c] += dp[nr][nc];
                    continue;
                }
                isVisited[nr][nc] = true;
                dp[r][c] += dfs(nr, nc);
                isVisited[nr][nc] = false;
            }
        }
        isVisitedHard[r][c] = true;
        return dp[r][c];
    }
}
