import java.util.*;
import java.io.*;

public class Main{
    
    private static int N;
    private static int[][] dp = new int[101][2];
    private static List<Integer> flowers = new ArrayList<>();
    private static int answer;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n;
        for(int i=1; i<=N; i++){
            n = Integer.parseInt(st.nextToken());
            flowers.add(n);
            for(int j=1; j<=100; j++){
                if(dp[j][0] != 0){
                    answer = Math.max(answer, dp[j][1] + (int) Math.pow(n - flowers.get(dp[j][0] - 1), 2));
                }
            }
            dp[n][0] = i;
            dp[n][1] = answer;
        }
        System.out.print(answer);
	}
}
