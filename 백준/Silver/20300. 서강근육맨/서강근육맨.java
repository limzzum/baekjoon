import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        long[] nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);
        long answer = 0;
        if(N %2 == 1){
            answer = nums[N-1];
            N -= 1;
        }

        for (int i = N-1; i >= N/2; i--) {
            answer = Math.max(answer, nums[i] + nums[N-1-i]);
        }
        System.out.println(answer);
    }

}
