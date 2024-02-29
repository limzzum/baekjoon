import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int sum = 0;
        int idx = N;
        for (int i = 0; i < N; i++) {
            if(nums[i] > 0){
                idx = i;
                break;
            }

            if(i != N-1 && nums[i+1] <= 0){
                sum += (nums[i] * nums[i+1]);
                i += 1;
                continue;
            }
            sum += nums[i];

        }
        for (int i = N-1; i >= idx; i--) {
            if((i != idx && nums[i-1]>1)){
                sum += (nums[i] * nums[i-1]);
                i -= 1;
                continue;
            }
            sum += nums[i];
        }
        System.out.println(sum);
    }

}
