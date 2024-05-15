import java.util.*;
import java.io.*;

public class Main{

    static int N, M;
    static Map<Integer, Integer> prices = new HashMap<>();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    for(int i=1; i<=N; i++){
	        prices.put(i, Integer.parseInt(br.readLine()));
	    }
	    
	    M = Integer.parseInt(br.readLine());
	    int sum = 0;
	    for(int i=0; i<M; i++){
	        sum += prices.get(Integer.parseInt(br.readLine()));
	    }
	    
        System.out.println(sum);
	}
}
