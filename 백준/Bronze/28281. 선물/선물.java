
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int pre = Integer.parseInt(st.nextToken()) * X;

        int sum = pre;

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            int price = Integer.parseInt(st.nextToken()) * X;
            sum += price;
            answer = Math.min(answer, sum);
            sum -= pre;
            pre = price;

        }
        System.out.println(answer);
    }

}