import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    char[] wordA = br.readLine().toCharArray();
	    char[] wordB = br.readLine().toCharArray();
	    char[] wordC = br.readLine().toCharArray();
	    
	    int[][][] dp = new int[wordA.length+1][wordB.length+1][wordC.length +1];
	    for(int i=0; i<wordA.length; i++){
	        for(int j=0; j<wordB.length; j++){
	            for(int k=0; k<wordC.length; k++){
	                if(wordA[i] == wordB[j] && wordB[j] == wordC[k]){
	                    dp[i+1][j+1][k+1] = dp[i][j][k] + 1;
	                }else{
	                    dp[i+1][j+1][k+1] = Math.max(dp[i][j+1][k+1], Math.max(dp[i+1][j][k+1], dp[i+1][j+1][k]));
	                }
	            }
	            
	        }
	    }	    
	    System.out.println(dp[wordA.length][wordB.length][wordC.length]);
	}	
}
