import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] gameScore;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gameScore = new int[N+1][M];
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                gameScore[i][j] = Integer.parseInt(st.nextToken()) + getBestScore(i-1, j);
                if(i==N){
                    answer = Math.min(answer, gameScore[i][j]);
                }
            }
        }
        System.out.println(answer);
    }
    private static int getBestScore(int pre, int exclude){
        int time = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            if(i == exclude){
                continue;
            }
            time = Math.min(time, gameScore[pre][i]);
        }
        return time;
    }
}
