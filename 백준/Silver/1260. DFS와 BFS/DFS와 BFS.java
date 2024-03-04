
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> qp = new LinkedList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        List<Integer>[] linkNode = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            linkNode[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String[] line = br.readLine().split(" ");
            int node1 = Integer.parseInt(line[0]);
            int node2 = Integer.parseInt(line[1]);
            linkNode[node1].add(node2);
            linkNode[node2].add(node1);
        }
        visited = new boolean[N+1];
        sb.append(K+" ");
        visited[K]=true;
        dfs(linkNode,K);
        sb.append("\n");
        visited = new boolean[N+1];
        sb.append(K+" ");
        visited[K]=true;
        bfs(linkNode,K);

        System.out.println(sb.toString());

    }

    private static void bfs(List<Integer>[] linkNode , int start) {
        qp.add(start);
        while(!qp.isEmpty()){
            int s = qp.poll();
            Collections.sort(linkNode[start]);
            for(int i=0; i<linkNode[s].size(); i++){
                int node = linkNode[s].get(i);
                if(visited[node]){
                    continue;
                }
                sb.append(node+" ");
                qp.add(node);
                visited[node] = true;
            }
        }
    }

    private static void dfs(List<Integer>[] linkNode , int start) {
        Collections.sort(linkNode[start]);
        for (int i=0; i<linkNode[start].size(); i++){
            int node = linkNode[start].get(i);
            if(visited[node]){
                continue;
            }
            sb.append(node+" ");
            visited[node] = true;
            dfs(linkNode,node);
        }
    }
}
