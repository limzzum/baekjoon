import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static Map<Integer, Integer> callCntMap = new HashMap<>();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    N = Integer.parseInt(br.readLine());
	    
        callCntMap.put(0, 1);
        callCntMap.put(1, 1);
        
        bw.write(String.valueOf(fibonacci(N)));
	    bw.flush();
	    bw.close();
	}
	
	private static int fibonacci(int n) {
	    if(callCntMap.get(n)!= null){
	        return callCntMap.get(n);
	    }
        callCntMap.put(n, (fibonacci(n-2) + fibonacci(n-1) + 1)%1000000007);
        return callCntMap.get(n);
    }
}
