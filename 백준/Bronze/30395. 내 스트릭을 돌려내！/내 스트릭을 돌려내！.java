import java.util.*;
import java.io.*;

public class Main{

	static int N;
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = 0;
	    int len = 0;
	    int freeze = 0;
	    int answer = 0;
	    for(int i=0; i<N; i++){
	        n = Integer.parseInt(st.nextToken());
	        if(n == 0){
	            if(freeze <= i){
	                freeze = i + 2;
	            }else {
	                answer = Math.max(answer, len);
	                len = 0;
	            }
	        }else {
	            len += 1;
	        }
	    }
	    answer = Math.max(answer, len);
	    System.out.print(answer); 
	} 
}
