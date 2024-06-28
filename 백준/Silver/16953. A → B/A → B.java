import java.util.*;
import java.io.*;

public class Main{
    
    static class Node {
        int n;
        int cnt;
        public Node(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
    }
    static int A, B;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(a -> a.cnt));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    A = Integer.parseInt(st.nextToken());
	    B = Integer.parseInt(st.nextToken());

        queue.add(new Node(B, 0));    
            
	    while(!queue.isEmpty()){
	        Node node = queue.poll();
	        if(node.n == A){
	            System.out.print(node.cnt + 1);
	            return;
	        }
	        if(node.n > A){
	            if(node.n % 2 == 0){
	                queue.add(new Node(node.n / 2, node.cnt + 1));
	            }else if(node.n % 10 == 1){
	                queue.add(new Node(node.n/10, node.cnt + 1));
	            }
	        }
	    }
	    System.out.print(-1);
	}

}
