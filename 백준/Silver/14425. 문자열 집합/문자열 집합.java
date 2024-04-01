import java.util.*;
import java.io.*;

public class Main{
    
    static int N, M;
    static Set<String> words = new HashSet();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    for(int i=0; i<N; i++){
	        words.add(br.readLine());
	    }
	    
	    int answer = 0;
	    for(int i=0; i<M; i++){
	        String word = br.readLine();
	        if(words.contains(word)){
	            answer += 1;
	        }
	    }
	    
	    System.out.println(answer);    
	}
}
