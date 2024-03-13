import java.util.*;
import java.io.*;

public class Main
{
    
    static class Node {
        long num;
        int cnt;
        
        public Node(long num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    static long N;
    static Map<Long, Boolean> isVisitedMap = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Queue<Node> queue = new ArrayDeque<>();
	    N = Long.parseLong(br.readLine());

	    queue.add(new Node(N, 0));
	    
	    while(!queue.isEmpty()){
	        Node node = queue.poll();
	        if(node.num == 1L){
	            System.out.println(node.cnt);
                return;
	        }
	        long nextNum;
	        if(node.num %3 == 0){
	            nextNum = node.num/3;
	            if(!isVisitedMap.containsKey(nextNum)){
	                isVisitedMap.put(nextNum, true);
	                queue.add(new Node(nextNum, node.cnt +1));
	            }
	        }
	        
	        if(node.num %2 == 0){
	            nextNum = node.num/2;
	            if(!isVisitedMap.containsKey(nextNum)){
	                isVisitedMap.put(nextNum, true);
	                queue.add(new Node(nextNum, node.cnt +1));
	            }
	        }
	        queue.add(new Node(node.num-1, node.cnt +1));
	    }
	    
	    
	    
	}
	
	
}
