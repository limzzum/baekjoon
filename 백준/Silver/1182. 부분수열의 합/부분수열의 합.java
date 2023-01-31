import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int count;
    static int [] nums;
    static int target;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        target = Integer.parseInt(input[1]);

        nums = new int[N];
        String [] line = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(line[i]);
        }

        dfs(0,0,0);
        System.out.println(count);
    }
    private static void dfs(int idx, int sum, int use){
        if(sum == target && use>0 ){
            count +=1;
        }
        if(idx==N){
            return;
        }
        dfs(idx+1, sum, use=0);
        dfs(idx+1, sum+nums[idx], use+1);
    }
}
