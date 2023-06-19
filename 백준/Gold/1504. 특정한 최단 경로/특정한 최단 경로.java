import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
* 다익스트라 최단경로 알고리즘을 이용할 수 있다.
* 다익스트라 알고리즘은 목적지까지 가기위한 경로도 모두 최단경로인 특징이 있으므로
* 경유지가 필요하다면 출발점 - 경로지 - 목적지 에서 출발점-경유지까지의 최단거리 + 목적지-경유지까지의 최단거리를 구할 수 있다.
* 경유지가 두 개 있으므로 경유의 순서를 구하여 최단 경로를 구할 수 있다.
* */
public class Main {
    static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.dist - o2.dist;
        }
    });
    static final int MAX_DISTANCE = 2_000_000 ;
    static final int NOWAY = 2_000_000 * 3;
    static int N;
    static int[][] nodes;
    static boolean[] isVisited;

    static class Node{
        int start;
        int end;
        int dist;
        public Node(int start, int end, int dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        nodes = new int[N][N];
        isVisited = new boolean[N];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            nodes[start][end] = cost;
            nodes[end][start] = cost;
        }
        st = new StringTokenizer(br.readLine());
        int waypointA = Integer.parseInt(st.nextToken()) - 1;
        int waypointB = Integer.parseInt(st.nextToken()) - 1;

        int result1 = getDistance(0, waypointA) + getDistance(waypointA, waypointB) + getDistance(waypointB, N - 1);
        int result2 = getDistance(0, waypointB) + getDistance(waypointB, waypointA) + getDistance(waypointA, N - 1);

        int answer = Math.min(result1, result2);
        if(answer >= NOWAY){
            System.out.println(-1);
            return;
        }
        System.out.println(answer);

    }

    private static int getDistance(int start, int end){
        if(start == end){
            return 0;
        }
        pq.clear();
        isVisited = new boolean[N];
        pq.add(new Node(start, end, 0));
        while (!pq.isEmpty()){
            Node poll = pq.poll();
            isVisited[poll.start] = true;
            if(poll.dist>= MAX_DISTANCE){
                return NOWAY;
            }
            if(poll.start == end){
                return poll.dist;
            }
            for (int i = 0; i < nodes[poll.start].length; i++) {
                if(!isVisited[i] && nodes[poll.start][i] != 0){
                    pq.add(new Node( i, end, poll.dist + nodes[poll.start][i]));
                }
            }
        }
        return NOWAY;
    }
}
