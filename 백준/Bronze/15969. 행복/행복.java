import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int min = 2000;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        System.out.println(max - min);

    }
}