import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[] wordA;
    static char[] wordB;
    static int[][] dp;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wordA = br.readLine().toCharArray();
        wordB = br.readLine().toCharArray();

        dp = new int[wordA.length+1][wordB.length+1];
        initDp();
        
        ans = dp[wordA.length][wordB.length];
        System.out.println(ans);

        if(ans!=0){
            char[] answerWord = getAnswerWord();
            System.out.println(answerWord);
        }

    }

    private static char[] getAnswerWord() {
        int r = dp.length -1;
        int c = dp[0].length -1;

        char[] word = new char[ans];
        int idx = ans-1;
        while (idx >= 0){
            if(dp[r][c] != dp[r-1][c] && dp[r][c] != dp[r][c-1]){
                word[idx] = wordA[r-1];
                idx -=1;
                r -= 1;
                c -= 1;
                continue;
            }

            if(dp[r-1][c]>dp[r][c-1]){
                r -= 1;
            }else{
                c -= 1;
            }
        }
        return word;
    }

    private static void initDp() {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(wordA[i-1] == wordB[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = dp[i-1][j-1];
                }
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
    }
}
