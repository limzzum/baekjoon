import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    
    static class Node{
        int num;
        int cnt;
        public Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    
    static int N, K;
    static Map<Integer, Boolean> isVisited = new HashMap();
    static int[] nums;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Queue<Node> queue = new ArrayDeque();
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    nums = new int[N];

	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<N; i++){
	        nums[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int num = Integer.parseInt(Arrays.stream(nums).mapToObj(Integer::toString).collect(Collectors.joining("")));
	    if(isCrescendo(num)){
	        System.out.println(0);
	        return;
	    }
	    queue.add(new Node(num, 0));
	    isVisited.put(num, true);
	    
	    while(!queue.isEmpty()){
	        Node node = queue.poll();
    
	        for(int i=0; i<= N - K; i++){
	            int reversed = reverse(node.num, i);
	            if(!isVisited.containsKey(reversed)){
	                if(isCrescendo(reversed)){
	                    System.out.println(node.cnt+1);
	                    return;
	                }
	                isVisited.put(reversed,true);
	                queue.add(new Node(reversed, node.cnt + 1));
	            }
	        }
	    }	    
	    System.out.println(-1);	    
    }
    
    private static boolean isCrescendo(int num){
        int pre = num % 10;

        while(num > 0){
            if(num % 10 > pre){
                return false;
            }
            pre = num % 10;
            num /= 10;
        }
        return true;
    }

    private static int reverse(int num, int idx){
        int start = N - idx -1;
        int end = N - (idx + K) ;

        for(int i=0; i< K/ 2; i++){
            int a = (int)(num/Math.pow(10, start-i)) % 10;
            int b = (int)(num/Math.pow(10, end+i)) % 10;
            num += -a * Math.pow(10, start-i) + a * Math.pow(10, end+i);
            num += -b * Math.pow(10, end+i) + b * Math.pow(10, start -i);
            
        }
        return num;
     }

}
