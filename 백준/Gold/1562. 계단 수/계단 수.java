import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int MOD = 1_000_000_000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N+1][10][1<<10];

        for(int i=1; i<10; i++){
            dp[1][i][1<<i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k< 1024; k++){
                    int bit = k | 1<<j;
                    if(j == 0){
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][1][k]) %MOD;
                    }else if(j==9){
                        dp[i][j][bit] = (dp[i][j][bit] +dp[i-1][8][k]) %MOD ;
                    }else{
                        dp[i][j][bit] = (dp[i][j][bit] + (dp[i-1][j-1][k] + dp[i-1][j+1][k]) %MOD) %MOD;
                    }
                }
            }
        }
        long answer =0;

        for(int i=0; i<10; i++){
            answer = (answer+ dp[N][i][1023])%MOD;
        }
        
        System.out.println(answer);
    }
}
