import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static int N;
	static int[][] foods;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		foods = new int[N][2];
		for(int i=0; i<N; i++) {
			String [] line = br.readLine().split(" ");
			foods[i][0] = Integer.parseInt(line[0]);
			foods[i][1] = Integer.parseInt(line[1]);
		}
		dfs(0,1,0);
		System.out.println(answer);
		
	}
	private static void dfs(int idx, int xin, int ssn) {
		if(idx==N) {
			if( xin >0 && ssn > 0) {
				answer = Math.min(answer, Math.abs(xin - ssn));
			}
			return;
		}
		dfs(idx+1, xin, ssn);
		dfs(idx+1, xin * foods[idx][0], ssn + foods[idx][1]);
	}
}
