import java.util.*;
import java.io.*;

public class Main{
    
    static int N, K;
    static int[] sum;
    static Map<Integer, Integer> map = new HashMap<>();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    map.put(0, 1);
        
	    sum = new int[N+1];
	    st = new StringTokenizer(br.readLine());	    
	    long answer = 0L;
	    for(int i=1; i<=N; i++){
	        sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
	        answer += map.getOrDefault(sum[i] - K, 0);
	        map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
	    }

	    System.out.println(answer);
	}
}
