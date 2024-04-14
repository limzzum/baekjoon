import java.util.*;
import java.io.*;

public class Main{
    
    static List<List<Integer>> buildings = new ArrayList();
    static List<Integer> timeToBuild = new ArrayList();
    static int N;
    static int[] dp;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    N = Integer.parseInt(br.readLine());
	    dp = new int[N];

	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        buildings.add(new ArrayList());
	        int n = Integer.parseInt(st.nextToken());
	        timeToBuild.add(n);
	        while(st.hasMoreTokens()){
	            n = Integer.parseInt(st.nextToken());
	            if(n == -1){
	                break;
	            }
	            buildings.get(i).add(n-1);
	        }
	    }
	    
  	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<N; i++){
	        sb.append(dfs(i)).append("\n");
	    }
	    System.out.println(sb);
	}
	
	private static int dfs(int n){
	    if(dp[n] != 0){
	        return dp[n];
	    }
	    if(buildings.get(n).size() == 0){
	        return dp[n] = timeToBuild.get(n);
	    }
	    
	    int max = 0;
	    for(int i=0; i<buildings.get(n).size(); i++){
	        int next = buildings.get(n).get(i);
	        max = Math.max(max, dfs(next));
	    }
	    
	    return dp[n] = timeToBuild.get(n) + max;
	}
}
