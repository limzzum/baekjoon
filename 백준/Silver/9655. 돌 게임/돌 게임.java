import java.util.*;
import java.io.*;

public class Main{
    
    private static final String SANGGEUN_WIN_MESSAGE = "SK";
    private static final String CHANGYOUNG_WIN_MESSAGE = "CY";

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    boolean [] dp = new boolean[N+3];
	    dp[1] = true;
	    dp[2] = false;
	    dp[3] = true;
	    
	    for(int i=4; i<= N; i++){
	        if(!dp[i-1] || !dp[i-3]){
	            dp[i] = true;
	        }
	    }
	    
	    if(dp[N]){
	        System.out.println(SANGGEUN_WIN_MESSAGE);
	    }else{
	        System.out.println(CHANGYOUNG_WIN_MESSAGE);
	    }
    }
}
