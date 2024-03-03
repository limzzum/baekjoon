
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int end = Integer.parseInt(input[1]);
		int time = 0;
		int current = 0;
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			int position = Integer.parseInt(line[0]);
			time += position-current;
			int delay = Integer.parseInt(line[1])+Integer.parseInt(line[2]);
			if(time%delay <Integer.parseInt(line[1])) {
				time+= Integer.parseInt(line[1]) - time%delay;
			}
			current = position;
		}
		
		System.out.println(time+(end-current));
	}

}
