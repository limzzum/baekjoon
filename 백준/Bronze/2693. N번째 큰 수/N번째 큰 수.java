import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int [] numCnt = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            numCnt = new int[1001];
            for (int j = 0; j < 10; j++) {
                numCnt[Integer.parseInt(st.nextToken())] += 1;
            }

            int sum = 0;
            for (int j = 1000; j > 0; j--) {
                sum += numCnt[j];
                if(sum >= 3){
                    sb.append(j).append("\n");
                    break;
                }
            }

        }
        System.out.println(sb);
    }
}
