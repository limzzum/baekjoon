import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] map = new int[9][9];
    static int[][][] rectangleStart = {{{0, 0}, {0, 3}, {0, 6}}, {{3, 0}, {3, 3}, {3, 6}}, {{6, 0}, {6, 3}, {6, 6}}};
    static List<int[]> zeroList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int zeroCnt = 0;
        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 0) {
                    zeroCnt += 1;
                    zeroList.add(new int[]{i, j});
                }
            }
        }
        dfs(0);

    }

    private static void dfs(int idx) {
        if(idx == zeroList.size()){
            for (int[] mm : map) {
                for (int m : mm) {
                    System.out.print(m);
                }
                System.out.println();
            }
            System.exit(0);
        }

            int r = zeroList.get(idx)[0];
            int c = zeroList.get(idx)[1];
            for (int k = 1; k <= 9; k++) {
                if (isAvailable(r,c, k)) {
                    map[r][c] = k;
                    dfs(idx + 1);
                    map[r][c] = 0;
                }

        }
    }


    private static boolean isAvailable(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == num) {
                return false;
            }
            if (map[i][c] == num) {
                return false;
            }
        }

        int rangeR = r / 3;
        int rangeC = c / 3;

        int startR = rectangleStart[rangeR][rangeC][0];
        int startC = rectangleStart[rangeR][rangeC][1];
        for (int i = startR; i < startR + 3; i++) {
            for (int j = startC; j < startC + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }
        return true;

    }
}
