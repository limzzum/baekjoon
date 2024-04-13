import java.util.*;
import java.io.*;

public class Main{
    
    static int N, K;
    static int answer;
    static int[] nums;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    double R = Double.parseDouble(st.nextToken());
	    double C = Double.parseDouble(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    R = Math.ceil(R/K);
	    C = Math.ceil(C/K);
	    
	    System.out.println((long)(R * C));
	}
}
