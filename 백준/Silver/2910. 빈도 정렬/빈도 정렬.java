import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    
    static int N, C;
    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, Integer> firstIndexMap = new HashMap<>();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<N; i++){
	        int n = Integer.parseInt(st.nextToken());
	        firstIndexMap.put(n, firstIndexMap.getOrDefault(n, i));
	        map.put(n, map.getOrDefault(n, 0) + 1);
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    map.entrySet().stream().sorted(Comparator.comparing((Map.Entry<Integer, Integer> a) -> -a.getValue()).thenComparing(a -> firstIndexMap.get(a.getKey())))
	        .forEach(a->{
	            for(int i=0; i<a.getValue(); i++){
	                sb.append(a.getKey()).append(" ");
	            }
	        });
	        
	    System.out.println(sb);
	}
}
