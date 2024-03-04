import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        double sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += pq.poll()/2.0;
        }
        sum += pq.poll();

        if(sum % 1 == 0){
            System.out.println((long)sum);
            return;
        }
        System.out.println(sum);
    }

}
