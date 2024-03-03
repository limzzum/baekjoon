import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int [] coin = new int[N];
        int [] cost = new int[K+1];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i <N; i++) {
            for (int j = 1; j <= K; j++)  {
                if(j<coin[i]){
                    continue;
                }
                if(j==coin[i]){
                    cost[j] = 1;
                }else if(cost[j-coin[i]]!=0){
                    cost[j] = cost[j-coin[i]]+1;
                }

            }
        }
        System.out.println(cost[K]);
    }
}
