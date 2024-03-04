import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int M;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int Tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < Tc; i++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[1]);
            M = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[2]);

            List<int[]> vegetable = new ArrayList<>();
            map = new int[N][M];
            int count = 0;

            for (int j = 0; j < K; j++) {
                String[] positon = br.readLine().split(" ");
                int r = Integer.parseInt(positon[1]);
                int c = Integer.parseInt(positon[0]);
                vegetable.add(new int[]{r, c});
                map[r][c] = 1;
            }
            for (int j = 0; j < vegetable.size(); j++) {
                int[] current = vegetable.get(j);
                int r = current[0];
                int c = current[1];
                if (map[r][c] == 0) {
                    continue;
                }
                count += 1;
                dfs(r,c);
            }
            sb.append(count+"\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int r, int c) {
        for (int k = 0; k < 4; k++) {
            if (r + row[k] >= 0 && r + row[k] < N && c + col[k] >= 0 && c + col[k] < M) {
                if (map[r+row[k]][c+col[k]]==1){
                    map[r+row[k]][c+col[k]]=0;
                    dfs(r+row[k],c+col[k]);

                }
            }
        }
    }

}