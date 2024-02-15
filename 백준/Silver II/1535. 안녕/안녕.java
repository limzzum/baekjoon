import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] health;
    static int[] love;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        health = new int[N];
        love = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            love[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(answer);

    }

    private static void dfs(int n, int healthSum, int loveSum){
        if(healthSum >= 100){
            return;
        }
        answer = Math.max(answer, loveSum);
        if(n == N){
            return;
        }
        dfs(n+1, healthSum, loveSum);
        healthSum += health[n];
        loveSum += love[n];
        dfs(n+1, healthSum, loveSum);

    }

}
