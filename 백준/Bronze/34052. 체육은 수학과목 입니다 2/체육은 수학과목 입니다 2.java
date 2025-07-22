import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 1500;
		for(int i=0; i<4; i++){
		    sum -= Integer.parseInt(br.readLine());
		    if(sum < 0){
		        System.out.print("No");
		        return;
		    }
		}
		
		System.out.print("Yes");
	}
}
