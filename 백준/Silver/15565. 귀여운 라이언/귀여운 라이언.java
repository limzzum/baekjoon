import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        int idx = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n == 1){
                nums[++idx] = i;
            }
        }
        if(idx < K){
            System.out.println(-1);
            return;
        }
        int left = 1;
        int right = K;
        int answer = Integer.MAX_VALUE;
        while (right <= idx){
            answer = Math.min(answer, nums[right] - nums[left] + 1);
            left += 1;
            right += 1;
        }
        System.out.println(answer);
    }

}
