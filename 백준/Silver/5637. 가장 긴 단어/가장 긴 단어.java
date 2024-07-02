import java.util.*;
import java.io.*;

public class Main{
    
	static int maxLen;
	static String answer;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st;
	    loop: while(true){
	        st = new StringTokenizer(br.readLine());
	        while(st.hasMoreTokens()){
	            String word = getRealWord(st.nextToken());
	            if(word.equals("E-N-D")){
	                break loop;
	            }
	            if(word.length() > maxLen){
	                maxLen = word.length();
	                answer = word;
	            }
	        }
	    }
	    
	    System.out.print(answer.toLowerCase());
	}
	
	private static String getRealWord(String word){
	    sb.setLength(0);
	    for(char w : word.toCharArray()){
	        if(w == '-' || (w >= 'A' && w <= 'z')){
	            sb.append(w);
	        }
	    }
	    return sb.toString();
	}
}
