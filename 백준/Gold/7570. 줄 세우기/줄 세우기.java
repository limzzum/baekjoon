import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] children = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            children[num] = i;
        }
        int[] dp = new int[N+1];
        dp[0] = 0;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if( children[i-1]<children[i]){
                dp[i] = dp[i-1] +1;
            }else{
                dp[i] = 1;
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(N-answer);
    }
}
