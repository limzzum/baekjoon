import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] nums = new int[N];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
		}
		
		int heigth = nums[N-1];
		int count = 1;
		for(int i= N-2; i>=0; i--) {
			if(nums[i]>heigth) {
				count+=1;
                heigth = nums[i];
			}
		}
		System.out.println(count);
	}
	

}
