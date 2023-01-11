package silver2.P2630;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2630 {
    static int N;
    static int[][] map;
    static int[] count = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }


        dfs(new int[]{0, 0}, N);
        System.out.println(count[0]);
        System.out.println(count[1]);

    }

    private static boolean isSameColor(int[] start, int size) {
        int color = map[start[0]][start[1]];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[start[0] + i][start[1] + j] != color) {
                    return false;
                }
            }
        }
        count[color] += 1;
        return true;
    }

    private static void dfs(int[] start, int size) {
        if (isSameColor(start, size)) {
            return;
        }
        dfs(new int[]{start[0], start[1]}, size / 2);
        dfs(new int[]{start[0], start[1] + size / 2}, size / 2);
        dfs(new int[]{start[0] + size / 2, start[1]}, size / 2);
        dfs(new int[]{start[0] + size / 2, start[1] + size / 2}, size / 2);

    }


}
