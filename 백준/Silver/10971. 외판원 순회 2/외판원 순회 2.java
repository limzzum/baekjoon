import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] cost;
    static int[] visited;
    static int N;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            String [] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited = new int[N];
        visited[0] = 1;
        dfs(0,0,1);

        System.out.println(answer);


    }

    private static void dfs( int pre, int sum, int count){
        if(count == N){
            if(cost[pre][0] == 0){
                return;
            }
            answer = Math.min(answer, sum+cost[pre][0]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i] == 0 && cost[pre][i] != 0) {
                visited[i] = 1;
                dfs(i,sum+cost[pre][i], count+1);
                visited[i] = 0;
            }
        }
    }
}
