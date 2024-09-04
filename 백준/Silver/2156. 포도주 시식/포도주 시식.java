import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] sum;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sum = new int[N+1][3];

        int n;
        for(int i=1; i<=N; i++){
            n = Integer.parseInt(br.readLine());
            sum[i][0] = Math.max(sum[i-1][2], Math.max(sum[i-1][0], sum[i-1][1]));
            sum[i][1] = sum[i-1][0] + n;
            sum[i][2] = sum[i-1][1] + n;
        }

        System.out.println(Math.max(sum[N][0], Math.max(sum[N][1], sum[N][2])));
    }

}
