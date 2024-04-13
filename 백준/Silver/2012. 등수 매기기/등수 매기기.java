import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    int[] nums = new int[N];
	    for(int i=0; i<N; i++){
	        nums[i] = Integer.parseInt(br.readLine());
	    }
	    
	    Arrays.sort(nums);
	    long answer = 0L;
	    for(int i=1; i<=N; i++){
	        answer += Math.abs(nums[i-1] - i);
	    }
	   
	    System.out.println(answer);
	}
}
