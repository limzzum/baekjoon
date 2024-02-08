import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] wordA = br.readLine().toCharArray();
        char[] wordB = br.readLine().toCharArray();
        int[][] dp = new int[wordA.length +1][wordB.length +1];

        int answer = 0;
        for (int i = 1; i <= wordA.length; i++) {
            for (int j = 1; j <= wordB.length; j++) {
                if(wordA[i-1] == wordB[j-1]){
                    dp[i][j] = 1;
                    if(i-2 >=0 && j-2 >=0 && wordA[i-2] == wordB[j-2]){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }

}
