import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int Tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<Tc; i++) {
			String[] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			
			int result = a % 10;
            if(result == 0){
                sb.append(10).append("\n");
                continue;
            }
			while(b>1) {
				result = (result*a)%10;
			    if(result == 0){
                    result = 10;
                    break;
                }
				b -= 1;
            }
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}