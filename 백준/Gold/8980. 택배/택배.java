import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static class Parcel {

        int from;
        int to;
        int weight;

        public Parcel(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }


    static int N, M;
    static int weight;
    static int[] weights;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Parcel> pq = new PriorityQueue<>((a, b) -> {
            if (a.to == b.to) {
                return b.from - a.from;
            }
            return a.to - b.to;
        });
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        weight = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        weights = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Parcel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())));
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            Parcel poll = pq.poll();

            answer += add(poll.from, poll.to, poll.weight);
        }

        System.out.println(answer);
}


    private static int add(int from, int to, int w) {
        int sum = Integer.MAX_VALUE;
        for (int i = from; i < to; i++) {
            if(weights[i] == weight){
                return 0;
            }
            sum = Math.min(sum, Math.min(weight - weights[i], w));
        }
        for (int i = from; i < to; i++) {
            weights[i] += sum;
        }
        return sum;
    }
    
}
