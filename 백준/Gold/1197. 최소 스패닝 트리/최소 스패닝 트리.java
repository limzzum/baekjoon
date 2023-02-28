import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int V;
    static int E;
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        Edge[] edges = new Edge[E];
        parent = new int[V];

        makeSet();
        for (int j = 0; j < E; j++) {
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]) - 1;
            int to = Integer.parseInt(line[1]) - 1;
            int cost = Integer.parseInt(line[2]);
            edges[j] = new Edge(from, to, cost);
        }

        Arrays.sort(edges);


        long sum = 0;
        int count = 0;
        for (int j = 0; j < E; j++) {
            if (union(edges[j].from, edges[j].to)) {
                count += 1;
                sum += edges[j].cost;
            }
            if (count == V - 1) {
                break;
            }
        }
        System.out.println(sum);
    }

    private static void makeSet() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    private static int findParent(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = findParent(parent[a]);
    }

    private static boolean union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a == b) {
            return false;
        }
        parent[a] = b;
        return true;
    }
}
