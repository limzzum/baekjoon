import java.io.*;

public class Main {

	static int count =0;
	public static void main(String[] agrs) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		String[] list = br.readLine().split(" ");
		
		for(int i=0; i<TC; i++) {
			check(Integer.parseInt(list[i]));
		}
		System.out.println(count);
	}
	static void check(int num) {
		if(num==1) {
			return;
		}
		if(num==2) {
			count++;
			return;
		}
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0)
				return;
		}
		count++;
	}
}
