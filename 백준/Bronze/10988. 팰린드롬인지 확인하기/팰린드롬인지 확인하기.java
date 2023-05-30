import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();

        for (int i = 0; i <= word.length/2; i++) {
            if(word[i]!=word[word.length-i-1]){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}