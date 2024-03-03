import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	static int [] count = new int[2];
	static int[][] dp = new int[41][2];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int Tc = Integer.parseInt(br.readLine());
		
		dp[0] = new int[]{1,0};
		dp[1] = new int[] {0,1};
		
		
		int[] num = new int[Tc];
		int idx = 0;
		int maxNum = 0;
		for(int i=0; i<Tc; i++) {
			count[0] = 0;
			count[1] = 0;
			num[idx] = Integer.parseInt(br.readLine());
			maxNum = Math.max(maxNum, num[idx]);
			idx+=1;
			fibonaci(maxNum);
			
		}
		for(int n: num) {
			sb.append(dp[n][0]+ " " + dp[n][1]).append("\n");
		}
	
		System.out.println(sb);
	}

	private static void fibonaci(int num) {
		for(int i=2; i<=40; i++) {
			dp[i]= new int[] {dp[i-1][0]+dp[i-2][0], dp[i-1][1]+dp[i-2][1]};
		}
	}

}
