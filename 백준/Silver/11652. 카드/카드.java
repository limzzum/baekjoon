import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        long pre = pq.poll();
        long answer = pre;
        int maxCnt = 1;
        int cnt = 1;
        while (!pq.isEmpty()){
            Long poll = pq.poll();
            if(pre == poll){
                cnt += 1;
            }else{
                pre = poll;
                cnt = 1;
            }
            if(cnt > maxCnt){
                maxCnt = cnt;
                answer = pre;
            }

        }
        System.out.println(answer);

    }

}
