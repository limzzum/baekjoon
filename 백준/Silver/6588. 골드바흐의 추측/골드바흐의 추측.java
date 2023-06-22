import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean [] dp = new boolean[1000001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = 0;
        boolean isPossible = false;
        initDecimal();

        while(true) {
            n = Integer.parseInt(br.readLine());

            if(n==0) {
                break;
            }
            isPossible = false;
            for(int i=2; i<=n/2; i++) {
                if(!dp[i] && !dp[n-i]){
                    sb.append(n).append(" = ").append(i).append(" + ").append(n-i);
                    isPossible = true;
                    break;
                }
            }
            if(!isPossible) {
                sb.append("Goldbach's conjecture is wrong.");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void initDecimal(){
        for (int i=2; i<=1000000; i++){
            if(dp[i]){
                continue;
            }
            for (int j = i*2; j <= 1000000; j+=i) {
                dp[j] = true;
            }
        }
    }

}