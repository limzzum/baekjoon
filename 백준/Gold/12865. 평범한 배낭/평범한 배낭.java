import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Bag {
        int weight;
        int value;
        public Bag(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    static int N, K;
    static Queue<Bag> bags = new PriorityQueue<>(Comparator.comparing(bag -> bag.weight));
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            bags.add(new Bag(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Bag bag;
        for(int i=1; i<=N; i++){
            bag = bags.poll();
            for(int j=0; j<=K; j++){
                if(bag.weight > j){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], bag.value + dp[i-1][j-bag.weight]);
            }
        }

        System.out.println(dp[N][K]);

    }

}
