import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    long[] numSum = new long[N+1];
	    long answer = 0L;
	    for(int i=1; i<= N; i++){
	        numSum[i] = numSum[i-1] + Integer.parseInt(st.nextToken());
	        if(i >= M){
	            answer = Math.max(answer, numSum[i] - numSum[i-M]);
	        }
	    }	    
	    System.out.println(answer);
	}
}
