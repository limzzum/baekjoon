import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] sum;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sum = new int[N+1][N+1];

        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                int max = Math.min(N-i, N-j);
                for(int k=0; k<=max; k++){
                    answer = Math.max(answer, sum[i+k][j+k] - sum[i+k][j-1] - sum[i-1][j+k] + sum[i-1][j-1]);
                }
            }
        }
        System.out.println(answer);
    }

}
