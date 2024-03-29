import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String word = br.readLine();
	    
	    int answer = 1;
	    while(!word.isEmpty()){
	        int len = word.indexOf("wo") + 1;
	        if(len == 0 || word.length() < len * 4 || !isWolfWord(word.substring(0, len *4))){
	            answer = 0;
	            break;
	        }
	        word = word.substring(len * 4);
	    }
	    
	    System.out.println(answer);
	}
	
	private static boolean isWolfWord(String word){
	    char[] words = word.toCharArray();
	    int len = words.length / 4;
	    
	    for(int i=0; i<len; i++){
	        if(words[i] != 'w' || words[i+len] != 'o' || words[i+len*2] != 'l' || words[i+len*3] != 'f'){
	            return false;
	        }
	    }
	    
	    return true;
	}
}
