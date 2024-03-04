import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int V;
    static int E;
    static boolean [] visited;
    static int [] dp;
    static PriorityQueue<Node> qp;
    static List<Node>[] nodes;
    static class Node{
        int from;
        int to;
        int cost;
        public Node(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        qp = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });

        String [] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        int start = Integer.parseInt(br.readLine()) - 1;
        visited = new boolean[V];
        dp = new int[V];

        nodes = new ArrayList[V];

        for(int i=0; i<V; i++){
            nodes[i] = new ArrayList<>();
        }

        for (int i=0; i<E; i++){
            String [] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0])-1;
            int to = Integer.parseInt(line[1])-1;
            int cost = Integer.parseInt(line[2]);
            nodes[from].add(new Node(from, to, cost));
        }
        visited[start] = true;
        bfs(start);
        for (int i=0; i<V; i++){
            if(dp[i] == 0 && i!=start){
                System.out.println("INF");
            }else{
                System.out.println(dp[i]);
            }

        }


    }
    private static void bfs(int start){
        for (int i=0; i<nodes[start].size(); i++){
            qp.add(nodes[start].get(i));
        }
        while (!qp.isEmpty()){
            Node poll = qp.poll();
            if(visited[poll.to]){
                continue;
            }
            visited[poll.to] = true;
            dp[poll.to] = poll.cost;
            for (int i=0; i<nodes[poll.to].size(); i++){
                    nodes[poll.to].get(i).cost += dp[poll.to];
                    qp.add(nodes[poll.to].get(i));

            }

        }

    }
}
