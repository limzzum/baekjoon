import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int sum = 0;
        for(int i=0; i<N; i++){
            sum += Integer.parseInt(br.readLine());
        }

	    System.out.print(sum);
	}
}
