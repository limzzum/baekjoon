import java.util.*;
import java.io.*;

public class Main{

    static char[] words;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        words = br.readLine().toCharArray();
        
        if(words.length == 1){
            System.out.println("AKARAKA");
            return;
        }
        
        int front = 0;
        int back = words.length -1;
        if(dfs(front, back)){
            System.out.println("AKARAKA");
            return;
        }
            System.out.println("IPSELENTI");
	}
	
	private static boolean dfs(int front, int back){
	    if(front == back){
	        return true;
	    }
	    
	    int len = (back - front + 1)/2 -1;

	    while(front <= back){
            if(words[front] != words[back]){
                return false;
            }

            front += 1;
            back -= 1;
        }	    
	    return dfs(front, front + len) && dfs(back - len, back);	    
	}
}
