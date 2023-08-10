import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        int[] nums = new int[N+1];
        int [] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }
        Arrays.sort(nums);

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i-1] + nums[i];
            sum += dp[i];
        }

        System.out.println(sum);
    }

}