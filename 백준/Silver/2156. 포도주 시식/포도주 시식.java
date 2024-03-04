import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];

        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        if(N<3){
            int sum = 0;
            for(int i= 0; i<N; i++){
                sum += nums[i];
            }
            System.out.println(sum);
            return;
        }

        dp[0] = nums[0];
        dp[1] = nums[0] +nums[1];
        dp[2] = Math.max(nums[2]+nums[1], Math.max(dp[1], nums[0]+nums[2]));
        for(int i=3; i<N; i++){
           dp[i] = Math.max(nums[i]+nums[i-1]+dp[i-3], nums[i]+dp[i-2]);
           dp[i] = Math.max(dp[i], dp[i-1]);
        }
        System.out.println(dp[N-1]);
    }

}
