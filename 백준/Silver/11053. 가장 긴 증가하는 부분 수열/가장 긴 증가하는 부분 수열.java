import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        dp[0]=1;
        String [] line = br.readLine().split(" ");
        int[] numbers = new int[N];
        stringToInt(line, numbers);

        for(int i=1; i<N; i++){
            dp[i]=1;
            for (int j=0; j<i; j++){
                if(numbers[i]>numbers[j] && dp[j]>=dp[i]){
                    dp[i]= dp[j]+1;
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[N-1]);

    }

    private static void stringToInt(String[] line, int[] numbers) {
        for(int i = 0; i<line.length; i++){
            numbers[i] =  Integer.parseInt(line[i]);
        }
    }

}
