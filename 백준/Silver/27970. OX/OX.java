import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static long MOD = (long) Math.pow(10,9) +7;
    private static long[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();
        dp =  new long[100000];

        init();

        long answer = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == 'O') {
                answer = (answer + dp[i]) % MOD;
            }
        }
        System.out.println(answer);

    }

    private static void init(){
        dp[0] = 1;
        long sum = 1;
        for (int i = 1; i <100000 ; i++) {
            dp[i] = (1 + sum) % MOD;
            sum = (sum + dp[i]) % MOD;
        }
    }
}
