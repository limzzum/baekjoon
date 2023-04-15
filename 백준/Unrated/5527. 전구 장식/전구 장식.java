import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int pre = Integer.parseInt(st.nextToken());
        int cnt = 1;
        while (st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(num != pre){
                cnt +=1;
                pre = num;
                continue;
            }

            queue.add(cnt);

            sum += cnt;
            if(queue.size() ==3){
                answer = Math.max(answer, sum);
                sum -= queue.poll();
            }
            cnt = 1;
        }
        sum += cnt;

        answer = Math.max(answer, sum);

        System.out.println(answer);

    }
}
