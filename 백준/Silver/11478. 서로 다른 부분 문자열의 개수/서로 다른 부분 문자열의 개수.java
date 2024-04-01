import java.util.*;
import java.io.*;

public class Main{
    
    static Set<String> words = new HashSet();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String word = br.readLine();
	    
	    for(int i=1; i<=word.length(); i++){
	        for(int j=0; j<= word.length() - i; j++){
	            words.add(word.substring(j, j+i));
	        }
	    }	    
	    System.out.println(words.size());    
	}	
}