import java.util.*;
import java.io.*;

public class Main{
    
    static long N, M;
    static Map<Long, Boolean> isVisited = new HashMap();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Long.parseLong(st.nextToken());
	    M = Long.parseLong(st.nextToken());
	    
	    if(dfs(N)){
	        System.out.println("YES");
	        return;
	    }
	    
	    System.out.println("NO");
	}
	
	private static boolean dfs(long n){
	    if(isVisited.containsKey(n)){
	        return false;
	    }
	    isVisited.put(n, true);
	    if(n == M){
	        return true;
	    }
	    if(n < M){
	        return false;
	    }
	    
	    if(n %2 == 0L){
	        return dfs(n/2);
	    }else {
	        if(dfs(n/2)){
	            return true;
	        }
	        return dfs(n/2 + 1);
	    }
	}
}
