import java.util.*;
import java.io.*;

public class Main{

    static final String vowel = "aeiou";
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();
        
        int cnt = 0;
        for(char word: words){
            if(vowel.contains(String.valueOf(word))){
                cnt += 1;
            }
        }        
        System.out.println(cnt);
	}
}
