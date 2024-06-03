import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static Set<String> words = new HashSet<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    for(int i=0; i<N; i++){
	        words.add(br.readLine());
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    words.stream().sorted(Comparator.comparing((String a) -> a.length()).thenComparing(a -> a))
	        .forEach(a -> sb.append(a).append("\n"));
	    System.out.print(sb);
	}

}
