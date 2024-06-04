import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
    
    static int N,M;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    M = Math.min(M, N - M);
	   
	    System.out.print(getAnswer());
	}
	
	private static String getAnswer(){
	    BigInteger answer = new BigInteger("1");
	    for(int i=0; i<M; i++){
	        answer = answer.multiply(BigInteger.valueOf(N-i));
	    }
	    
	    for(int i=0; i<M; i++){
	        answer = answer.divide(BigInteger.valueOf(M-i));
	    }
	    return answer.toString();
	}

}
