import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{

    static int N, K;
    static int cnt;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(!dfs(0, 0, new int[N])){
            System.out.print(-1);
        }
        
    }
    
    private static boolean dfs(int idx, int sum, int[] nums){
        if(sum == N){
            cnt += 1;
            if(cnt == K){
                String answer = Arrays.stream(nums, 0, idx).mapToObj(x -> String.valueOf(x)).collect(Collectors.joining("+"));
                System.out.print(answer);
                return true;
            }
            return false;
        }
        if(sum > N){
            return false;
        }
        
        for(int i=1; i<=3; i++){
            nums[idx] = i;
            if(dfs(idx + 1, sum + i, nums)){
                return true;
            }
        }
        return false;
    }
}
