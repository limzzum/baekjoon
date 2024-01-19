import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] nums;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        dfs(0, 0, new StringBuilder());
    }

    static private void dfs(int start, int n, StringBuilder sb){
        if(n == M){
            System.out.println(sb);
            return;
        }
        for (int i = start; i < N; i++) {
                dfs(i,n + 1, new StringBuilder(sb).append(nums[i]).append(" "));

        }
    }

}
