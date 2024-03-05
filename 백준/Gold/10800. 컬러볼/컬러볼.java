import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class ColorBall{
        int idx;
        int color;
        int size;

        public ColorBall(int idx, int color, int size){
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<ColorBall> colorBalls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            colorBalls.add(new ColorBall(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        colorBalls.sort(Comparator.comparingInt(a -> a.size));

        int[] colorSize = new int[N+1];
        int sum = 0;
        int curSum = 0;
        int pre = -1;
        int[] dp = new int[N+1];

        int [] answer = new int[N];
        for (ColorBall colorBall : colorBalls) {
            if(colorBall.size > pre){
                dp = new int[N+1];
                pre = colorBall.size;
                curSum = 0;
            }
            if(dp[colorBall.color] == 0){
                answer[colorBall.idx] = sum - curSum - colorSize[colorBall.color] + 1;
                dp[colorBall.color] = answer[colorBall.idx];
            }else{
                answer[colorBall.idx] = dp[colorBall.color];
            }

            sum += colorBall.size;
            curSum += colorBall.size;
            colorSize[colorBall.color] += colorBall.size;

        }

        for (int ans : answer) {
            sb.append(ans-1).append("\n");
        }

        System.out.println(sb);

    }

}
