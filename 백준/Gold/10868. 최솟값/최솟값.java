import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int S=1;
    static int[] nums;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while (S<N){
            S *=2;
        }

        nums = new int[S*2];
        for (int i = 0; i < N; i++) {
            nums[S+i] = Integer.parseInt(br.readLine());
        }

        for (int i = S-1; i >0 ; i--) {
            nums[i] = Math.min(nums[i*2], nums[i*2+1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            int result = dfs(1, 1,S, startIdx, endIdx);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    private static int dfs(int current, int startIdx, int endIdx, int targetStartIdx, int targetEndIdx){
        if(startIdx > targetEndIdx || endIdx < targetStartIdx){
            return Integer.MAX_VALUE;
        }
        if(startIdx >= targetStartIdx && endIdx <= targetEndIdx){
            return nums[current];
        }
        int mid = (startIdx+endIdx)/2;
        int a = dfs(current*2,startIdx, mid,targetStartIdx, targetEndIdx);
        int b = dfs(current*2+1, mid+1, endIdx, targetStartIdx, targetEndIdx);
        return Math.min(a,b);
    }
}
