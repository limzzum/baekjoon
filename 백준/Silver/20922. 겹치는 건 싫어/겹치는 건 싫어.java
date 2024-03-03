import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAXNUM = 100000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] count = new int[MAXNUM + 1];
        int[] nums = new int[N];
        int maxLen = 0;
        int start = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            nums[i] = n;
            count[n] += 1;
            if(count[n]>K){
                for (int j = start; j < i; j++) {
                    if(nums[j] == n){
                        start = j+1;
                        count[n] -= 1;
                        break;
                    }
                }
            }

            maxLen = Math.max(maxLen, i - start + 1);
        }
        System.out.println(maxLen);
    }
}
