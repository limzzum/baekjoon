import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String[][] words = new String[N][];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().split("");
        }


        loop : for (int i = 0; i < words[0].length; i++) {
            String w = words[0][i];
            for (int j = 1; j < N; j++) {
                if(!words[j][i].equals(w)){
                    sb.append("?");
                    continue  loop;
                }
            }
            sb.append(w);
        }
        System.out.println(sb);
    }
}
