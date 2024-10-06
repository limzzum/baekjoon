import java.util.*;
import java.io.*;

public class Main{

    static int N;
    static int[] count;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    init();
	    System.out.print(count[N]);
	}
	
	private static void init(){
	    count = new int[N+1];
	    for(int i=1; i<= N; i++){
	        count[i] = Integer.MAX_VALUE;
	        for(int j=1; j<=Math.sqrt(i); j++){
	            count[i] = Math.min(count[i], count[i - (int)Math.pow(j, 2)] + 1); 
            }
	    }
	}
   
}
