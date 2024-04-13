import java.util.*;
import java.io.*;

public class Main{
    
    static long N, P, Q, X, Y;
    static Map<Long, Long> map = new HashMap();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        
	    System.out.println(dfs(N));
	}
	
	private static long dfs(long n){
	    if(map.containsKey(n)){
	        return map.get(n);
	    }
	    if(n <=0){
	        map.put(n, 1L);
	        return 1;
	    }
	    
	    map.put(n, dfs(n/P-X) + dfs(n/Q -Y));
	    return map.get(n);	   
	} 
}
