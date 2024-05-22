import java.util.*;
import java.io.*;

public class Main{
    
    static class Node{
        int cur;
        int cnt;
        public Node(int cur, int cnt){
            this.cur = cur;
            this.cnt = cnt;
        }
    }
    
    static int N, M, A, B;
    static int[] parent;
    static List<Integer>[] childs;
    static boolean[] isVisited;
    static int answer = -1;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    Queue<Node> queue = new ArrayDeque<>();
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        
        parent = new int[N+1];
        childs = new ArrayList[N+1];
        isVisited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parent[b] = a;
            if(childs[a] == null){
                childs[a] = new ArrayList<>();
            }
            childs[a].add(b);
        }
        
        queue.add(new Node(A, 0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.cur == B){
                answer = node.cnt;
                break;
            }
            
            if(!isVisited[parent[node.cur]]){
                isVisited[parent[node.cur]] = true;
                queue.add(new Node(parent[node.cur], node.cnt +1));
            }
            if(childs[node.cur] == null){
                continue;
            }
            for(int child : childs[node.cur]){
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.add(new Node(child, node.cnt +1));
                }
            }
        }
        
        bw.write(String.valueOf(answer));
	    bw.flush();
	    bw.close();
	}
}
