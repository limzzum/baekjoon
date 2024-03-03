import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] isVisited;
    static int w, h;
    static int[] row = {0, -1, 0, 1, -1, -1, 1, 1};
    static int[] col = {-1, 0, 1, 0, -1, 1, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h== 0){
                break;
            }
            map = new int[h][w];
            isVisited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(isVisited[i][j] || map[i][j] == 0){
                        continue;
                    }
                    dfs(i,j);
                    cnt += 1;
                }
            }
            sb.append(cnt).append("\n");

        }
        System.out.println(sb);
    }
    private static void dfs(int r, int c){
        isVisited[r][c] = true;
        for (int i = 0; i < 8; i++) {
            int nr = r + row[i];
            int nc = c + col[i];
            if(nr<0 || nr>= h || nc <0 || nc>=w){
                continue;
            }
            if(isVisited[nr][nc] || map[nr][nc]==0){
                continue;
            }
            dfs(nr,nc);
        }
    }
}
