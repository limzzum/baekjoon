import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int coke = Integer.parseInt(st.nextToken()) / 2;
        int beer = Integer.parseInt(st.nextToken());

        int ans = Math.min((coke + beer), N);
        System.out.println(ans);
    }

}