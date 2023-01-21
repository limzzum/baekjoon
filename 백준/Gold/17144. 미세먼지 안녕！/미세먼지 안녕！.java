import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] row = {0,-1,0,1};
    static int[] col = {-1,0,1,0};
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> qp = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int t = Integer.parseInt(input[2]);

        int [][] map = new int[r][c];
        int cleanerUp =0;
        int cleanerDown = 0;
        for(int i=0; i<r; i++){
            String [] line = br.readLine().split(" ");
            for(int j=0; j<c; j++){
                map[i][j] = Integer.parseInt(line[j]);
                if(map[i][j] == -1){
                    cleanerDown = i;
                }
            }
        }
        cleanerUp = cleanerDown-1;

        for(int tc= 0; tc<t; tc++) {

            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    if(map[i][j] >0){
                        qp.add(new int[]{i,j,map[i][j]});
                    }
                }
            }

            while (!qp.isEmpty()) {
                int[] poll = qp.poll();
                int cnt = 0;
                int dust = poll[2] / 5;
                for (int i = 0; i < 4; i++) {
                    int currentR = poll[0] + row[i];
                    int currentC = poll[1] + col[i];
                    if (currentR >= 0 && currentR < r && currentC >= 0 && currentC < c) {
                        if (map[currentR][currentC] != -1) {
                            map[currentR][currentC] += dust;
                            cnt += 1;
                        }
                    }
                }
                map[poll[0]][poll[1]] -= dust * cnt;
            }

            for (int i = cleanerUp - 2; i >= 0; i--) {
                map[i + 1][0] = map[i][0];
            }
            for (int i = 1; i < c; i++) {
                map[0][i - 1] = map[0][i];
            }
            for (int i = 1; i <= cleanerUp; i++) {
                map[i - 1][c - 1] = map[i][c - 1];
            }
            for (int i = c - 2; i > 0; i--) {
                map[cleanerUp][i + 1] = map[cleanerUp][i];
            }
            map[cleanerUp][1] = 0;

            for (int i = cleanerDown + 2; i < r; i++) {
                map[i - 1][0] = map[i][0];
            }
            for (int i = 1; i < c; i++) {
                map[r - 1][i - 1] = map[r - 1][i];
            }
            for (int i = r - 2; i >= cleanerDown; i--) {
                map[i + 1][c - 1] = map[i][c - 1];
            }
            for (int i = c - 2; i > 0; i--) {
                map[cleanerDown][i + 1] = map[cleanerDown][i];
            }
            map[cleanerDown][1] = 0;

        }

        int sum = 0;
        for (int[] ints : map) {
            for (int anInt : ints) {
                if(anInt>0){
                    sum+=anInt;
                }
            }
        }
        System.out.println(sum);
    }
}
