import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int len = N-start+1;

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < Q; i++) {
            int idx = Integer.parseInt(br.readLine());
            if(idx<N){
                sb.append(nums[idx]);
            }else{
                idx-=N;
                idx%=len;
                sb.append(nums[start-1+idx]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
