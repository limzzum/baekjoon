import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int [] nums;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			String [] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			
			if(N == 0) {
				System.out.println(sb);
				return;
			}
			
			nums = new int[N];
			for(int i=0; i<nums.length; i++) {
				nums[i] = Integer.parseInt(input[i+1]);
			}
			
			for(int i=0; i<=nums.length-6; i++) {
				dfs(nums[i]+"", i+1,1);
			}
			sb.append("\n");
		}
		
	
	}
	private static void dfs(String ans, int idx, int cnt) {
		if(cnt == 6){
			sb.append(ans).append("\n");
			return;
		}
		for(int i=idx; i<nums.length ; i++) {
			dfs(ans+" "+nums[i], i+1, cnt+1);
		}
	}
	

}
