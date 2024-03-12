import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int[] nums;
    static int[] count = new int[4];
    static int maxAnswer = Integer.MIN_VALUE;
    static int minAnswer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    nums = new int[N];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<N; i++){
	        nums[i] = Integer.parseInt(st.nextToken());
	    }
	    st = new StringTokenizer(br.readLine());
	    
	    for(int i=0; i<4; i++){
	        count[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    dfs(1, nums[0]);
	    
	    System.out.println(maxAnswer);
	    System.out.println(minAnswer);

	    
	}
	
	private static void dfs(int idx, long sum){
	    if(idx == N){
	        maxAnswer = Math.max(maxAnswer, (int) sum);
	        minAnswer = Math.min(minAnswer, (int) sum);
	        return;
	    }
	    
	    for(int i=0; i<4; i++){
	        if(count[i] > 0){
	            count[i] -= 1;
	            dfs(idx +1, getCalculateNum(sum , nums[idx], i));
	            count[i] += 1;
	        }
	    }
	}
	
	private static long getCalculateNum(long a, int b, int i){
	    if(i==0){
	        return a + b; 
	    }
	    
	    if(i==1){
	        return a - b; 
	    }
	    
	    if(i==2){
	        return a * b; 
	    }
	    
	    if(i==3){
	        return a / b; 
	    }
	    
	    return 0;
	}
}
