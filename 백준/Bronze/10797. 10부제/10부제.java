import java.util.*;
import java.io.*;

public class Main{

    static int N;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int ans = 0;
	    for(int i=0; i<5; i++){
	        int n = Integer.parseInt(st.nextToken());
	        if(N == n){
	            ans += 1;
	        }
	    }
	    System.out.println(ans);
	}
}
