import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static int CY = 100;
    static int SD = 100;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            match(a,b);
        }
        
        System.out.println(CY);
        System.out.print(SD);
	}
	
	private static void match(int a, int b){
	    if(a == b){
	        return;
	    }
	    
	    if(a > b){
	        SD -= a;
	    }else {
	        CY -= b;
	    }
	}
}
