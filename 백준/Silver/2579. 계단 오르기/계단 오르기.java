import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N+2];

        // 바로 앞 계단을 선택하지 않았을 경우, 바로 앞 계단을 선택할 경우 두 가지 합에 대해 계산.
        // 첫번째 경우는 앞앞 계단의 누적합 중 큰 것과 더하기.
        // 두번째 경우는 앞계단을 선택하려면 앞계단에서는 앞계단을 선택하지 않았어야 하므로 앞계단의 [0]번째 값과 더하기.
        int [][] sum = new int[N+2][2];
        for(int i=2; i<scores.length; i++){
            scores[i] = Integer.parseInt(br.readLine());
            sum[i][0] = Math.max(sum[i-2][0], sum[i-2][1]) + scores[i];
            sum[i][1] = sum[i-1][0] + scores[i];
        }
        int answer = Math.max(sum[N+1][0], sum[N+1][1]);
        System.out.println(answer);
    }
}
