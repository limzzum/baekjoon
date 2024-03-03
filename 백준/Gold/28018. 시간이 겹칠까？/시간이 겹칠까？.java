import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[1000002];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            count[S] += 1;
            count[E+1] -= 1;
        }

        for (int i = 2; i <= 1000000; i++) {
            count[i] +=count[i-1];
        }

        int Q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(count[n]).append("\n");
        }

        System.out.println(sb);
    }
}
