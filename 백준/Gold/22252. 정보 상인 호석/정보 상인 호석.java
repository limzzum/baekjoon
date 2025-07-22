import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static Map<String, Queue<Integer>> map = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		String query;
		String name;
		int n;
		long sum = 0;
		for(int i=0; i<N; i++){
		    st = new StringTokenizer(br.readLine());
		    query = st.nextToken();
		    name = st.nextToken();
		    map.putIfAbsent(name, new PriorityQueue<>(Comparator.comparing(x -> -x)));
		    n = Integer.parseInt(st.nextToken());
		    if(query.equals("1")){
		        for(int j=0; j<n; j++){
		            map.get(name).add(Integer.parseInt(st.nextToken()));
		        }
		    }else {
		        if(map.get(name) == null){
		            continue;
		        }
		        for(int j=Math.min(n, map.get(name).size()); j>0; j--){
		            sum += map.get(name).poll();    
		        }
		    }
		}
		System.out.print(sum);
	}
}
