import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static final class Bus{
        int from;
        int cost;

        public Bus(int from, int cost){
            this.from = from;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }
    }

    static int N;
    static int M;
    static List<Bus>[] bus;
    static boolean[] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Bus> pq = new PriorityQueue<>(Comparator.comparingInt((Bus a) -> a.cost));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        bus = new ArrayList[N+1];
        isVisited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            String[] path = br.readLine().split(" ");
            int from = Integer.parseInt(path[0]);
            int to = Integer.parseInt(path[1]);
            int cost = Integer.parseInt(path[2]);

            if(bus[to] == null){
                bus[to] = new ArrayList<>();
            }

            bus[to].add(new Bus(from, cost));

        }
        String[] dest = br.readLine().split(" ");
        int from = Integer.parseInt(dest[0]);
        int to = Integer.parseInt(dest[1]);


        pq.addAll(bus[to]);

        isVisited[to] = true;
        while (!pq.isEmpty()){
            Bus poll = pq.poll();
            if(poll.from == from){
                System.out.println(poll.cost);
                return;
            }
            if(isVisited[poll.from]){
                continue;
            }
            isVisited[poll.from] = true;
            
            if(bus[poll.from] == null){
                continue;
            }
            for (int i = 0; i < bus[poll.from].size(); i++) {
                Bus b = bus[poll.from].get(i);
                pq.add(new Bus(b.from, b.cost + poll.cost));
            }
        }

    }
}
