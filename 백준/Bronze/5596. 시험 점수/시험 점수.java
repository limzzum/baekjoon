import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mingukSum = 0;
        for (int i = 0; i < 4; i++) {
            mingukSum += Integer.parseInt(st.nextToken());
        }

        int manseSum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            manseSum += Integer.parseInt(st.nextToken());
        }

        int ans = Math.max(mingukSum, manseSum);
        System.out.println(ans);
    }
}