import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int M;
    static boolean[][] isUsedWord;
    static int knowWordCnt;
    static boolean[][] isForgot;
    static int[] forgotCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        isUsedWord = new boolean[N][26];
        isForgot = new boolean[N][26];
        forgotCnt = new int[N];

        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();
            for (int j = 0; j < word.length; j++) {
                isUsedWord[i][word[j]-'a'] = true;
            }
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            char b = input[1].charAt(0);
            knowWordCnt = 0;
            if(a==1){
                addForgotList(b);
            } else {
                removeForgotList(b);
            }
            sb.append(knowWordCnt).append("\n");

        }
        System.out.println(sb);
    }

    private static void addForgotList(char forgotWord){
        for (int i = 0; i < N; i++) {
            if(isUsedWord[i][forgotWord-'a']){
                isForgot[i][forgotWord-'a'] = true;
                forgotCnt[i] +=1;
                continue;
            }
            if(forgotCnt[i] == 0){
                knowWordCnt +=1;
            }
        }
    }

    private static void removeForgotList( char forgotWord){
        for (int i = 0; i < N; i++) {
            if(isUsedWord[i][forgotWord-'a']){
                isForgot[i][forgotWord - 'a'] = false;
                forgotCnt[i] -= 1;
            }
            if(forgotCnt[i] == 0){
                knowWordCnt +=1;
            }
        }
    }
}
