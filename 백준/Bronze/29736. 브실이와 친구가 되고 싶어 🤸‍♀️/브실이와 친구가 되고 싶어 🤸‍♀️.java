import java.util.*;
import java.io.*;

public class Main{
    
    static int A, B, K, X;
    static int[] dp;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    A = Integer.parseInt(st.nextToken());
	    B = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    K = Integer.parseInt(st.nextToken());
	    X = Integer.parseInt(st.nextToken());
	    
	    int min = Math.max(A, K-X);
	    int max = Math.min(B, K+X);
	    
	    String ans = String.valueOf(Math.max(0,max - min + 1));
	    if(ans.equals("0")){
	        ans = "IMPOSSIBLE";
	    }
	    
        bw.write(ans);
	    bw.flush();
	    bw.close();
	}
}
