import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int count;
    static int bigArea;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !isVisited[i][j]){
                    isVisited[i][j] = true;
                    count += 1;
                    bigArea = Math.max(bigArea, dfs(i, j, 1));
                }
            }
        }
        System.out.println(count);
        System.out.println(bigArea);



    }

    private static int dfs(int r, int c, int area){
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + row[i];
            int nc = c + col[i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                continue;
            }
            if(isVisited[nr][nc]){
                continue;
            }
            isVisited[nr][nc] = true;
            if(map[nr][nc] == 1){
                count += dfs(nr, nc, area + 1);
            }
        }

        return count;
    }
}
