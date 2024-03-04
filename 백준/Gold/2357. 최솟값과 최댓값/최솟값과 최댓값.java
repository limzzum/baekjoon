import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int S =1;
    static int[][] nums;
    static int min;
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        while (S<N){
            S*=2;
        }
        nums = new int[S*2][2];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[S+i][0]= num;
            nums[S+i][1]= num;
        }

        for (int i = S-1; i >0; i--) {
            nums[i][0] = Math.min(nums[i*2][0], nums[i*2+1][0]);
            nums[i][1] = Math.max(nums[i*2][1], nums[i*2+1][1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            max = 0;
            dfs(1,1,S,startIdx,endIdx);
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int current , int startLeft, int startRight, int targetLeft, int targetRight){
        if(startLeft > targetRight || startRight < targetLeft) return;
        if(startLeft >= targetLeft && startRight <= targetRight){
            min = Math.min(min, nums[current][0]);
            max = Math.max(max, nums[current][1]);
            return;
        }
        else{
            int mid = (startLeft + startRight) / 2;
            dfs(current*2, startLeft, mid, targetLeft, targetRight);
            dfs(current*2+1, mid+1, startRight, targetLeft, targetRight);
        }
    }
}
