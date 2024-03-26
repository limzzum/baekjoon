import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int L = Integer.parseInt(br.readLine());
	    int A = Integer.parseInt(br.readLine());
	    int B = Integer.parseInt(br.readLine());
	    int C = Integer.parseInt(br.readLine());
	    int D = Integer.parseInt(br.readLine());
	    
	    int answer = L - Math.max((A/C + Math.min(A%C, 1)), (B/D + Math.min(B%D, 1)));
	    System.out.println(answer);
	    
	}
}
