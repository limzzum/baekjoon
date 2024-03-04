import java.io.*;

public class Main{
    static int N;
    static int[] nums;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[17];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(input[i]);
            nums[n] =2;
        }
        String[] answer = new String[N*2];

        int result = dfs(0,answer);
        if(result == 0) {
        	System.out.println(-1);
        }
    }
    private static int dfs(int idx, String[] ans){
     
        if(idx==N*2){
            for (String a: ans){
                System.out.print(a+" ");
            }
            return 1;
        }
        if(!(ans[idx] == null)){
        	
            return dfs(idx+1,ans);
        }
        for(int i=0; i<17; i++){
            if(nums[i]>0){
                if(idx+i+1 < N*2 && !(ans[idx+i+1] == null)){
                    continue;
                }
                if(idx+i+1 < N*2){
                    ans[idx] = String.valueOf(i);
                    ans[idx+i+1] = String.valueOf(i);
                    nums[i] =0;
                    int result = dfs(idx+1, ans);
                    if(result == 1) {
                    	return 1;
                    }
                    nums[i] = 2;
                    ans[idx] = null;
                    ans[idx+i+1] = null;
                }

            }
        }
        return 0;
    }
}