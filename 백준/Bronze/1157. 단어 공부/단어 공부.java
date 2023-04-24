import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] word = br.readLine().toCharArray();

        int[] cnt = new int[32];
        int maxCnt = 0;
        char maxWord = word[0];
        for (int i = 0; i < word.length; i++) {
            if(word[i]>=97){
                word[i] -= 32;
            }
            cnt[word[i]-'A'] += 1;
            if(cnt[word[i]-'A'] == maxCnt){
                maxWord = '?';
            }
            else if(cnt[word[i]-'A']> maxCnt){
                maxCnt = cnt[word[i]-'A'];
                maxWord = word[i];
            }
        }

        bw.write(String.valueOf(maxWord).toUpperCase());
        bw.flush();
        bw.close();

    }
}
