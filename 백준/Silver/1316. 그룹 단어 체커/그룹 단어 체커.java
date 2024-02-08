import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numIdx;
        int answer = 0;
        loop : for (int i = 0; i < N; i++) {
            numIdx = new int[27];
            char[] words = br.readLine().toCharArray();
            for (int j = 0; j < words.length; j++) {
                int word = words[j] - 'a';
                if(numIdx[word] == 0 || j + 1 - numIdx[word] == 1 ){
                    numIdx[word] = j+1;
                }else {
                    continue loop;
                }
            }
            answer += 1;

        }
        System.out.println(answer);
    }

}
