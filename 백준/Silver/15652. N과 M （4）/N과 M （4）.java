import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        dfs(1,new int[M], 0);
        System.out.println(sb);
    }

    private static void dfs(int start, int[] answer, int idx){
        if(idx == M){
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<=N; i++){
            answer[idx] = i;
            dfs(i,answer,idx+1);

        }
    }
}
