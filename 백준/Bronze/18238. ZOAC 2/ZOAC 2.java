import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    char[] words = br.readLine().toCharArray();
	    
	    char cur = 'A';
	    int answer = 0;
	    for(int i=0; i<words.length; i++){
	        answer += Math.min(Math.min(Math.abs(words[i] - cur),  26-cur + words[i]), Math.min(Math.abs(cur - words[i]), cur + 26-words[i]));
	        cur = words[i];
	    }
	    System.out.print(answer);
	}
	
}
