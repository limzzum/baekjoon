import java.util.*;
import java.io.*;

public class Main{
    
    static int N, X;
    static int[] nums;
    static Map<Integer, Integer> numCount = new HashMap<>();
    static long answer;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            numCount.put(nums[i], numCount.getOrDefault(nums[i], 0) + 1);
        }
        X = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            answer += numCount.getOrDefault(X-nums[i], 0);
        }
        System.out.print(answer/2);
	}
}
