import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] connect;
    //visite == 2는 아예 끝, 1은 검사 중, 0은 방문안함
    static int[] visited;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int Tc = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < Tc; tc++) {
            int N = Integer.parseInt(br.readLine());
            connect = new int[N+1];
            visited = new int[N+1];
            answer = N;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                connect[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if(visited[i]==0){
                    dfs(i);
                }
            }
            sb.append(answer).append("\n");

        }
        System.out.println(sb);
    }
    private static int dfs(int n){
        if(visited[n] == 2){
            return 0;
        }
        if(visited[n]==1){
            return n;
        }
        if(connect[n] == n){
            answer -= 1;
            visited[n] =2;
            return 0;
        }
        visited[n] = 1;
        int result = dfs(connect[n]);
        if(result == n){
            answer -=1;
            visited[n] = 2;
            return 0;
        }
        if(result != 0){
            answer -= 1;
        }
        visited[n] = 2;
        return result;

    }

}
