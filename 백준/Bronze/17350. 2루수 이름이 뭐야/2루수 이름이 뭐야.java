import java.util.*;
import java.io.*;

public class Main{
    
	static int N;
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    for(int i=0; i<N; i++){
	        if(br.readLine().equals("anj")){
	            System.out.print("뭐야;");
	            return;
	        }
	    }
	    
	    System.out.print("뭐야?");
	}
}
