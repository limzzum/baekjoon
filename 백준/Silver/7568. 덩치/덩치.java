import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] weight = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i][0] = Integer.parseInt(st.nextToken());
            weight[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N; j++) {
                if(i== j){
                    continue;
                }
                if(weight[j][0] > weight[i][0] && weight[j][1] > weight[i][1]){
                    cnt += 1;
                }
            }
            sb.append(cnt).append(" ");
        }
        System.out.println(sb);
    }

}