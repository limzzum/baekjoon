import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, L, N;
    static int minDrop;
    static int maxDrop;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int n;
        for(int t = 0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            for(int i=0; i<N; i++){
                n = Integer.parseInt(br.readLine());
                minDrop = Math.max(minDrop, Math.min(n, L - n));
                maxDrop = Math.max(maxDrop, Math.max(n, L - n));
            }
            sb.append(minDrop).append(" ").append(maxDrop).append("\n");
            minDrop = 0;
            maxDrop = 0;
        }
        System.out.println(sb);
    }

}
