import java.util.*;
import java.io.*;

public class Main{
    
    private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		if(N%2 == 0){
		    System.out.print(2);
		}else {
		    System.out.print(1);
		}
	}
}
