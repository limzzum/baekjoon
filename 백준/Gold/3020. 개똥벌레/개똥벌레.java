import java.util.*;
import java.io.*;

public class Main{

    static int N, M;
    static int[] under;
    static int[] ceiling;
    static int min = 200000;
    static int[] count;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    under = new int[M+1];
	    ceiling = new int[M+1];
	    count = new int[N+1];
	    
	    for(int i=0; i<N; i++){
	        
	        if(i%2 == 0){
	            under[Integer.parseInt(br.readLine())] += 1;
	        }else{
	            ceiling[Integer.parseInt(br.readLine())] += 1;
	        }
	    }
	    
	    int cnt = N/2;
	    for(int i=1; i<=M; i++){
	        cnt += under[M -i + 1];
	        count[cnt] += 1;
	        if(cnt < min){
	            min = cnt;
	        }
	        cnt -= ceiling[i];
	    }
	    
        System.out.print(min + " "+ count[min]);
	}
	
}
