import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main
{
    static int N;
    static List<Long> nums = new ArrayList<>();
    static long answer;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    N = Integer.parseInt(br.readLine());
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<N; i++){
	        nums.add(Long.parseLong(st.nextToken()));
	    }
	    
	    Collections.sort(nums);

	    answer = nums.get(N-1) * nums.get(N-2);
	    if(N <4){
	        System.out.println(answer);
	        return;
	    }
	    
	    int left;
	    int right;
	    long size;
	    long sum =0;
	    for(int i=0; i<N-1; i++){
	        for(int j=N-1; j>i; j--){
	            size = nums.get(i) + nums.get(j);
	            left = i+1;
	            right = j-1;
	            sum = nums.get(i) * nums.get(j);
	           
	            while(left < right){
	                long leftNum = nums.get(left);
	                long rightNum = nums.get(right);
	                if(leftNum + rightNum == size){
	                    sum += leftNum * rightNum;
	                    left += 1;
	                    right -= 1;
	                }else if(leftNum + rightNum < size){
	                    left += 1;
	                }else{
	                    right -= 1;
	                }
	            }
	            answer = Math.max(answer, sum);

	        }
	    }
	    System.out.println(answer);
    }
}
