import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i=N; i> 0; i--){
	        for(int j=0; j<i-1; j++){
	            sb.append(" ");
	        }
	        for(int j=0; j<(N+1-i)*2-1; j++){
	            sb.append("*");
	        }
	        sb.append("\n");
	    }
	    System.out.println(sb);
	}
}
