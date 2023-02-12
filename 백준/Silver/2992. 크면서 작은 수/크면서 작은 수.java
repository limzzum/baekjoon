import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String[] nums;
    static int answer= 999999;
    static int target;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        nums = input.split("");
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        target = Integer.parseInt(input);

        dfs("");
        if(answer == 999999){
            answer = 0;
        }
        System.out.println(answer);

    }
    private static void dfs(String ans){
        if(ans.length() == nums.length){
            int num = Integer.parseInt(ans);
            if(num > target){
                answer = Math.min(answer, num);
            }
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(ans+ nums[i]);
                visited[i] = false;
            }
        }
    }
}
