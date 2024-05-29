import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static int[] nums;
    static int[] orderNums;
    static int answer;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=0; i<N; i++){
	        nums[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int cnt = 0;
	    orderNums = nums.clone();
	    for(int i=0; i<N-1; i++){
	        for(int j=0; j<N -1 - i; j++){
	            if(nums[j] > nums[j+1]){
	                cnt += 1;
	                int temp = nums[j+1];
	                nums[j+1] = nums[j];
	                nums[j] = temp;
	            }
	        }
	    }
	    answer = cnt;
	    cnt = 0;
	    for(int i=0; i<N-1; i++){
	        for(int j=0; j<N -1 - i; j++){
	            if(orderNums[j] < orderNums[j+1]){
	                cnt += 1;
	                int temp = orderNums[j+1];
	                orderNums[j+1] = orderNums[j];
	                orderNums[j] = temp;
	            }
	        }
	    }
	    answer = Math.min(answer, cnt +1);
	    System.out.print(answer);
	}
}
