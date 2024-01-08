import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> b - a);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                if (pq.isEmpty()) {
                    sb.append("-1");
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            } else {
                for (int j = 0; j < n; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));

                }

            }
        }
        System.out.println(sb);
    }

}
