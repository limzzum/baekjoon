import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(char word : words){
            sb.append(word);
            idx = (idx + 1) % 10;
            if(idx == 0){
                sb.append("\n");
            }
        }       
        System.out.println(sb);
	}
}
