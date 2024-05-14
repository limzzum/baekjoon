import java.util.*;
import java.io.*;

public class Main{
    
    static int N, S;
    static int[] diffs;
    static int min = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
	    N = Integer.parseInt(st.nextToken());
	    S = Integer.parseInt(st.nextToken());
	    diffs = new int[N];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<N; i++){
	        diffs[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
	        min = Math.min(min, diffs[i]);
	    }
	    
	    bw.write(String.valueOf(getMinNum()));
	    bw.flush();
	    bw.close();
	}
	
	private static int getMinNum(){
	    if(isOkay(min)){
	            return min;
	    }
	    
	    for(int i= min/2; i>0; i--){
	        if(min % i == 0 && isOkay(i)){
	            return i;
	        }
	    }
	    return 0;
	}
	
	private static boolean isOkay(int n){
	    for(int diff : diffs){
	        if(diff % n != 0){
	            return false;
	        }
	    }
	    return true;
	}
}
