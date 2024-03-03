import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static final String SPLIT_PATTERN = "*+-/";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long Total = Long.parseLong(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		long sum = 0;
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			long price = Long.parseLong(line[0]);
			long cnt = Long.parseLong(line[1]);
			sum += price*cnt;
		}
		
		if(Total == sum) {
			System.out.println("Yes");
			return;
		}
		System.out.println("No");
		
	}
	
}
