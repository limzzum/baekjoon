import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), "/");
	    
	    int K = Integer.parseInt(st.nextToken());
	    int D = Integer.parseInt(st.nextToken());
	    int A = Integer.parseInt(st.nextToken());
	    
	    if(D == 0 || K + A < D){
	        System.out.println("hasu");
	    }else{
	        System.out.println("gosu");
	    }    
	}
}
