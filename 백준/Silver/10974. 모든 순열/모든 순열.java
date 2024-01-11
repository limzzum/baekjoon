import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[] isUsed = new boolean[9];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        savePermutation(1, "");
        System.out.println(sb);
    }

    private static void savePermutation(int cur, String answer){
        if(cur > N){
            sb.append(answer).append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(!isUsed[i]){
                isUsed[i] = true;
                savePermutation(cur + 1, answer+i+" ");
                isUsed[i] = false;
            }
        }
    }



}
