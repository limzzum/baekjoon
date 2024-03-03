import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i=1; i<=14; i++){
            dp[0][i] = i;
        }

        for (int i=0; i<tc; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int count = getCount(k,n);
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }

    private static int getCount(int floor, int ho){
        if(floor == 0){
            return dp[0][ho];
        }
        int sum = 0;
        for (int i=1; i<=ho; i++){
            if(dp[floor-1][i]==0){
                dp[floor-1][i] = getCount(floor-1, i);
            }
            sum += dp[floor-1][i];
        }
        return sum;
    }
}