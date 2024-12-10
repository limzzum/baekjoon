import java.util.*;
import java.io.*;

public class Main{
    
    static final int MOD = 1_000_000_007;
    static final int WIN = 1;
    static final int LOSE = 2;
    static final int DRAW = 0;
    
    static char[] infos;
    static int answer;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    char start = br.readLine().charAt(0);
	    infos = br.readLine().toCharArray();
	    
	    dfs(0, start, -1);
	    System.out.print(answer);
	}
	
	private static void dfs(int n, char pre, int preResult){
	    if(n==infos.length){
	        if(preResult != -1){
	            answer = (answer + 1) % MOD;
	        }
	        return;
	    }
	    
	    dfs(n+1, pre, preResult);
	    
	    int result = getGameResult(pre, infos[n]);
	    if(preResult == WIN && result == DRAW){
	        return;
	    }
	    dfs(n+1, infos[n], getGameResult(pre, infos[n]));
	}
	
	private static int getGameResult(char a, char b){
	    if(a == 'R'){
	        if(b == 'R'){
	            return DRAW;
	        }else if(b == 'P'){
	            return LOSE;
	        }else {
	            return WIN;
	        }
	    }else if(a == 'P'){
	        if(b == 'R'){
	            return WIN;
	        }else if(b == 'P'){
	            return DRAW;
	        }else {
	            return LOSE;
	        }
	    }else {
	        if(b == 'R'){
	            return LOSE;
	        }else if(b == 'P'){
	            return WIN;
	        }else {
	            return DRAW;
	        }
	    }
	}
	
}
