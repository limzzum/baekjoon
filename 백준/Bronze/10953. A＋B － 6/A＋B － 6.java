import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    int sum;
	    for(int i= 0; i<N; i++){
	        st = new StringTokenizer(br.readLine(),",");
	        sum = Integer.parseInt(st.nextToken());
	        sum += Integer.parseInt(st.nextToken());
	        sb.append(sum).append("\n");
	        
	    }
	    System.out.println(sb);
	}
}
