import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
* 첫번째는 부분조합을 구하여 두 집단으로 나눌 때 두 집단의 눈의 합의 차이가 가장 적은 조합을 선택하면,
* 두 집단 중 큰 눈의 합이 답이 된다.
*
* 두번째는 그냥 우선순위큐에 내림차순으로 정렬되도록 눈의 값들을 넣어준다.
* 최소시간을 구하려면 무조건 큰 집은 선택해주어야하는데 다른 집은 어떤 집을 선택하던 상관이없다.
* 그래서 가장 큰 집 두 집을 선택하여 눈을 치워 주도록 한다.

* N이 1일 때는 예외처리를 해준다.
*
* 이 풀이는 두 번 째 방식을 사용하였다.
*
* */
public class Main {
    static int N;
    static int[] arr;
    static final int TIME_MAX = 1440;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        if(N==1){
            int num = Integer.parseInt(st.nextToken());
            if(num>1440){
                System.out.println(-1);
                return;
            }
            System.out.println(num);
            return;
        }

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int time = 0;
        while (pq.size()>=2){
            int big1 = pq.poll();
            int big2 = pq.poll();

            big1 -= big2;
            time += big2;

            if(big1 !=0){
                pq.add(big1);
            }
            if(time > TIME_MAX){
                System.out.println(-1);
                return;
            }

        }
        if(!pq.isEmpty()){
            time += pq.poll();
        }

        if(time> TIME_MAX){
            System.out.println(-1);
            return;
        }
        System.out.println(time);

    }

}
