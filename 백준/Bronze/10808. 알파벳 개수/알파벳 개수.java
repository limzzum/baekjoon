import java.util.*;
import java.io.*;

public class Main{
    
    static int[] count = new int[26];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();
        
        for(char word : words){
            count[word - 'a'] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            sb.append(count[i]).append(" ");
        }        
        System.out.println(sb);
    }
}