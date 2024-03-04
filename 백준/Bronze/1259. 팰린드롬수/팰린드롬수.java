import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            char[] word = br.readLine().toCharArray();
            if(word.length == 1 && word[0] =='0'){
                break;
            }
            String ans = "yes";
            for (int i = 0; i <= word.length/2; i++) {
                if(word[i]!=word[word.length-i-1]){
                    ans = "no";
                    break;
                }
            }
            sb.append(ans).append("\n");

        }
        System.out.println(sb);

    }
}