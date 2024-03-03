import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] map;
    static int answer;
    static int[] row = {0,-1,-1};
    static int[] col = {-1, -1, 0};
    static long[][][] dp;
    static int[][] xvalue = {{0,1}, {0,1,2}, {1,2}};

    static class CountSum {
        int leftCnt ;
        int crossCnt;
        int downCnt;
        public CountSum(int leftCnt, int crossCnt, int downCnt) {
            this.leftCnt = leftCnt;
            this.crossCnt = crossCnt;
            this.downCnt = downCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp  = new long[N][N][3];

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        for (int i = 1; i < N; i++) {
            if(map[0][i] == 1) {
                break;
            }
            dp[0][i][0] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    continue;
                }
                getCount(i,j);

            }
        }


        long answer = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
        System.out.println(answer);


    }
    private static void getCount(int r, int c){
        for (int i = 0; i < 3; i++) {
            int nr = r+row[i];
            int nc = c+col[i];
            if(isIn(nr,nc)){
                for (int j = 0; j < xvalue[i].length; j++) {
                    if(i == 1 ){
                        if(map[r-1][c] == 1){
                            break;
                        }
                        if(c>0 && map[r][c-1] == 1){
                            break;
                        }
                    }
                    dp[r][c][i] += dp[nr][nc][xvalue[i][j]];

                }

            }
        }

    }

    private static boolean isIn(int r, int c) {
        if (r >= 0 && r < N && c >= 0 && c < N) {
            if (map[r][c] == 0) {
                return true;
            }
        }
        return false;
    }
}