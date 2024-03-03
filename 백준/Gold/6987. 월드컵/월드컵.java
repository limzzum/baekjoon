import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	  static int[][] countrys;
	  static int [][] fighters = new int[15][2];
	  static int answer =0;
	  public static void main(String [] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        
	        getMatches();
	        for(int i=0; i<4; i++) {
	        	countrys = new int[6][3];
	        	String[] input = br.readLine().split(" ");
	        	int sum = 0;
	        	for(int j= 0; j<18; j++) {
	        		int idx = j%3;
	        		int num = Integer.parseInt(input[j]);
	        		sum += num;
	        		countrys[j/3][j%3] = num;
	        	}
	        	if(sum !=30) {
	        		sb.append(0).append(" ");
	        		continue;
	        	}
	        	answer = 0;
	        	dfs(0);
	        	sb.append(answer).append(" ");

	        }
	        
	        System.out.println(sb);

	  }
	  
	  private static void getMatches() {
		  int idx = 0;
		  for(int i=0; i<6; i++) {
			  for(int j= i+1; j<6; j++) {
				  fighters[idx][0] = i;
				  fighters[idx][1] = j;
				  idx += 1;
			  }
		  }
	  }
	  private static void dfs(int idx) {
		  if(idx==15) {
			  answer = 1;
			  return;
		  }
		  int country1 = fighters[idx][0];
		  int country2 = fighters[idx][1];
		  
		  //1번째 나라가 이겼을 때 
		  
		  countrys[country1][0] -=1;
		  countrys[country2][2] -=1;
		  if(countrys[country1][0]>=0 && countrys[country2][2]>=0) {
			  dfs(idx+1);
		  }
		  countrys[country1][0] +=1;
		  countrys[country2][2] +=1;
		  
		  
		  // 무승부
		  countrys[country1][1] -=1;
		  countrys[country2][1] -=1;
		  
		  if(countrys[country1][1]>=0 && countrys[country2][1]>=0) {
			  dfs(idx+1);
		  }
		  countrys[country1][1] +=1;
		  countrys[country2][1] +=1;
		  
		  // 1번째 나라가 졌을 때
		  countrys[country1][2] -=1;
		  countrys[country2][0] -=1;
		  
		  if(countrys[country1][2]>=0 && countrys[country2][0]>=0) {
			  dfs(idx+1);
		  }
		  countrys[country1][2] +=1;
		  countrys[country2][0] +=1;
		 
	  }
	 
}
