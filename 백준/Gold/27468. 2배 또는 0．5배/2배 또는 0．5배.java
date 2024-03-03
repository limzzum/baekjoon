import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N ;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        int [] answer = new int[N];
        if(N%4 == 3){
            answer[1] = 3;
        }else{
            answer[1] = 2;
        }
        answer[0] = 1;
        visited[answer[0]]= true;
        visited[answer[1]] = true;
        sb.append(1).append(" ").append(answer[1]).append(" ");

        for (int i=2; i<N; i++){
            int diff = Math.abs(answer[i-1]-answer[i-2]);
            if(diff == 1){
                answer[i] = answer[i-1]+2;
            }else{
                if(visited[answer[i-1]-1]){
                    answer[i] = answer[i-1]+1;
                }else{
                    answer[i] = answer[i-1] -1;
                }
            }
            visited[answer[i]]= true;
            sb.append(answer[i]).append(" ");
        }
        System.out.println("YES");
        System.out.println(sb);

    }
}
