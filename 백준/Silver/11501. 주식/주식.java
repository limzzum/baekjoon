import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = null;

	    int T = Integer.parseInt(br.readLine());
	    
	    int N;
	    int[] nums;
	    int[] maxNum;
	    long sum;
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<T; i++){
	        N = Integer.parseInt(br.readLine());
	        nums = new int[N];
	        maxNum = new int[N];
	        sum = 0;
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<N; j++){
	            nums[j] = Integer.parseInt(st.nextToken());
	        }
	        
	        maxNum[N-1] = nums[N-1];
 	        for(int j=N-2; j>=0; j--){
	            maxNum[j] = Math.max(maxNum[j+1], nums[j]);
	        }
	        
	        for(int j=0; j<N; j++){
	            if(nums[j] != maxNum[j]){
	                sum += maxNum[j] - nums[j];
	            }
	        }
	        sb.append(sum).append("\n");
	    }
	    
	    System.out.println(sb);
	}
}
