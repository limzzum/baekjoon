
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	static int N;
	static int M;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	String[] input = br.readLine().split(" ");
    	int N = Integer.parseInt(input[0]);
    	int M = Integer.parseInt(input[1]);
    	
    	String[] line = br.readLine().split(" ");
    	int [] nums = new int[line.length];
    	
    	int idx = 0;
    	for(String n: line) {
    		int num = Integer.parseInt(n);
    		nums[idx] = num;
    		idx+=1;
    	}
    	
    	int [] dp = new int[nums.length+1];
    	
    	dp[0] = 0;
    	for(int i=1; i<dp.length; i++) {
    		dp[i] = dp[i-1] + nums[i-1];
    	}
    	
    	for(int i=0; i<M; i++) {
    		String [] comm = br.readLine().split(" ");
    		int start = Integer.parseInt(comm[0]);
    		int end = Integer.parseInt(comm[1]);
    		sb.append(dp[end]-dp[start-1]).append("\n");
    	}
    	System.out.println(sb);
    	
    }
   
    
  
}