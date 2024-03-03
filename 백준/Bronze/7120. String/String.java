import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();
        char preWord = input[0];
        sb.append(input[0]);
        for (int i = 0; i < input.length; i++) {
            if(input[i] == preWord){
                continue;
            }
            sb.append(input[i]);
            preWord = input[i];
        }
        System.out.println(sb);
    }
}