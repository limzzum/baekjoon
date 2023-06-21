import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_NUM = 1_000_000;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] odd = new int[MAX_NUM+1];
        st = new StringTokenizer(br.readLine());

        int oddIdx = 1;
        int startIdx = 0;
        int chance = K;

        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n % 2== 1){
                if(chance == 0){
                    startIdx += 1;
                    chance += 1;
                }
                chance -= 1;
                odd[oddIdx++] = i;

            }
            answer = Math.max(answer, i -odd[startIdx] -(K-chance));

        }

        System.out.println(answer);
    }
}
