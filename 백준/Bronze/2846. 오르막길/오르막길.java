import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        int pre = Integer.parseInt(st.nextToken());
        int nums [] = new int[N];
        nums[0] = pre;
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            if(num> nums[i-1]){
                ans = Math.max(ans, num - pre);
                continue;
            }
            pre = num;
        }
        System.out.println(ans);
    }
}
