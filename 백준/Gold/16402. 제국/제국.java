import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    
    static int N, M;
    static int[] parent;
    static Map<String, Integer> codeMap = new TreeMap();
    static int code = 1;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    parent = new int[N+1];
	    
	    for(int i=0; i<N; i++){
	        String name = br.readLine().split(" ")[2];
	        codeMap.put(name, code);
	        parent[code] = code;
	        code += 1;
	    }
	    
	    for(int i=0; i<M; i++){
	        st = new StringTokenizer(br.readLine(), ",");
	        int a = codeMap.get(st.nextToken().split(" ")[2]);
	        int b = codeMap.get(st.nextToken().split(" ")[2]);
	        int win = Integer.parseInt(st.nextToken());
	        if(win == 1){
	            union(a,b);
	        }else{
	            union(b,a);
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    int cnt = (int) codeMap.entrySet().stream().filter(entry ->
	        find(entry.getValue()) == entry.getValue())
	        .peek(entry->{
	        sb.append("Kingdom of ").append(entry.getKey()).append("\n");
	    }).count();

	    System.out.println(cnt);
	    System.out.println(sb);
	    
	}
	    private static int find(int a){
	        if(parent[a] == a){
	            return a;
	        }
	        
	        return parent[a] = find(parent[a]);
	    }
	    
	    private static void union(int a, int b){
	        if(find(a) == find(b)){
	            parent[a] = a;
	            parent[parent[b]] = a;
	        }else{
	            parent[parent[b]] = parent[a];
	        }
	    }
}
