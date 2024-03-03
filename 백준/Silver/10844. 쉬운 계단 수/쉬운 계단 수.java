
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static final int MOD = 1000000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N==1){
            System.out.println(9);
            return;
        }

        long sum =0;
        long [][] count = new long[N+1][11];
        for(int i =1; i<=9; i++){
            count[1][i] = 1;
        }

        for (int i=1; i<N; i++){
            for(int j = 0; j<=9; j++){
                if(j==0) {
                    count[i + 1][1] += count[i][0];
                    count[i + 1][1] %= MOD;
                    continue;
                }
                if(j==9) {
                    count[i + 1][8] += count[i][9];
                    count[i + 1][8] %= MOD;
                    continue;
                }
                count[i+1][j-1] += count[i][j];
                count[i+1][j-1] %= MOD;
                count[i+1][j+1] += count[i][j];
                count[i+1][j+1] %= MOD;
            }
        }
        for (long i : count[N]) {
            sum += i;
            sum %= MOD;
        }

        System.out.println(sum);
    }

}
