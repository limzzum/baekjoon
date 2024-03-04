
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] board;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		board = new int [20][20];
		int result = -1;
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			int r = Integer.parseInt(line[0]);
			int c = Integer.parseInt(line[1]);
			
			int v = 1;
			if(i%2==1) {
				v = 2;
			}
			board[r][c] = v;
			//r ,c 좌표에 대해서 세로줄, 가로줄 대각선 연속 5개 있는지 확인
			if(check(r,c,v)==true) {
				result = i+1;
				break;
			}
		}
		System.out.println(result);
	}
	
	private static boolean check(int r, int c , int v) {
		int count = 1;
		if(c>1) {
		for(int i=c-1; i>0; i--) {
			if(board[r][i]== v) {
				count +=1;
			}
			else {
				break;
			}
		}
		}
		if(c<19) {
			for(int i=c+1; i<20; i++) {
				if(board[r][i]== v) {
					count +=1;
				}
				else {
					break;
				}
			}
		}
		
		if(count==5) {
			return true;
		}
		
		count =-1;
		for(int i=r; i>0; i--) {
			if(board[i][c]== v) {
				count +=1;
			}
			else {
				break;
			}
		}
		for(int i=r; i<20; i++) {
			if(board[i][c]== v) {
				count +=1;
			}
			else {
				break;
			}
		}
		if(count==5) {
			return true;
		}
		
		count =1;
		for(int i=1; i<=6; i++) {
			if(r+i<20 && c+i <20) {
				if(board[r+i][c+i]==v) {
					count +=1;
				}else {
					break;
				}
			}}
		for(int i=1; i<=6; i++) {
			if(r-i>0 && c-i>0) {
				if(board[r-i][c-i] == v) {
					count+=1;
				}else {
					break;
				}
			}
		}
		if(count ==5) {
			return true;
		}
		
		count =1;
		for(int i=1; i<=6; i++) {
			if(r+i<20 && c-i >0) {
				if(board[r+i][c-i]==v) {
					count +=1;
				}else {
					break;
				}
			}
		}
		for(int i=1; i<=6; i++) {
			if(r-i>0 && c+i<20) {
				if(board[r-i][c+i] == v) {
					count+=1;
				}else {
					break;
				}
			}
		}
		if(count ==5) {
			return true;
		}
		
		return false;
	}
	
}
