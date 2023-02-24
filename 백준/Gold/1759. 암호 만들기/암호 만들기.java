import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int L;
    static int C;
    static String[] words;
    static final String VOWEL = "aeiou";
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        words = br.readLine().split(" ");
        Arrays.sort(words);
        combination(0,"");
        System.out.println(sb);

    }

    private static void combination(int startIdx, String ans){
        if(ans.length() == L){
            int count = 0;
            for (String a: ans.split("")){
                if(VOWEL.contains(a)){
                    count+=1;
                }
            }
            if(count>0 && L - count >=2){
                sb.append(ans).append("\n");
            }

            return;
        }
        for(int i=startIdx; i<C; i++){
            combination(i+1,ans+words[i]);
        }
    }
}