import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] nodes;
    static boolean[][] canGo;
    static String answer = "sad";
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Tc = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < Tc; tc++) {
            int N = Integer.parseInt(br.readLine());
            nodes = new int[N+2][2];
            visited = new boolean[N + 2];
            answer = "sad";

            String[] str = br.readLine().split(" ");
            nodes[0][0] = Integer.parseInt(str[0]);
            nodes[0][1] = Integer.parseInt(str[1]);

            for (int i = 1; i <= N; i++) {
                str = br.readLine().split(" ");
                nodes[i][0] = Integer.parseInt(str[0]);
                nodes[i][1] = Integer.parseInt(str[1]);
            }

            str = br.readLine().split(" ");
            nodes[N+1][0] = Integer.parseInt(str[0]);
            nodes[N+1][1] = Integer.parseInt(str[1]);

            canGo = new boolean[N + 2][N + 2];

            for (int i = 0; i < N+2; i++) {
                for (int j = i+1; j < N+2; j++) {
                    if (i == j) continue;
                    int dist = Math.abs(nodes[i][0] - nodes[j][0]) + Math.abs(nodes[i][1] - nodes[j][1]);
                    if (dist <= 1000) {
                        canGo[i][j] = true;
                        canGo[j][i] = true;
                    }
                }
            }

            dfs(0);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean dfs(int idx) {
        visited[idx] = true;
        if(idx == canGo.length-1){
            answer = "happy";
            return true;
        }
        for (int i = 1; i <canGo[idx].length; i++) {
            if(canGo[idx][i] && !visited[i]){
                if(dfs(i)){
                    return true;
                }
            }
        }
        return false;
    }
}
