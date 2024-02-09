import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPackagePrice = Integer.MAX_VALUE;
        int minPerPrice = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minPackagePrice = Math.min(minPackagePrice, Integer.parseInt(st.nextToken()));
            minPerPrice = Math.min(minPerPrice, Integer.parseInt(st.nextToken()));
        }

        int answer = Math.min(N * minPerPrice,
            Math.min((N / 6 * minPackagePrice) + (N % 6 * minPerPrice),
                (Math.min(1, N % 6) + N / 6) * minPackagePrice));

        System.out.println(answer);
    }

}
