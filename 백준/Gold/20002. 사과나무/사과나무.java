import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int[][] sumMap;
    static int answer = -301;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sumMap = new int[N+1][N+1];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                answer = Math.max(answer, map[i][j]);
                sumMap[i+1][j+1] = map[i][j] + sumMap[i][j+1] + sumMap[i+1][j] - sumMap[i][j];
            }
        }

        int size = 2;
        while (size <= N){
            for (int i = size; i <= N; i++) {
                for (int j = size; j <= N; j++) {
                    answer = Math.max(answer, sumMap[i][j] - sumMap[i-size][j] - sumMap[i][j-size] + sumMap[i-size][j-size]);
                }
            }
            size += 1;
        }
        System.out.println(answer);


    }

}
