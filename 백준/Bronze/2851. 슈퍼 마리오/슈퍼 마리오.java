import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int sum = 0;
	    int diff = 100;
	    int n;
	    for(int i=0; i<10; i++){
	        n = Integer.parseInt(br.readLine());
	        if(Math.abs(100 - (sum + n)) < diff
	            || Math.abs(100 - (sum + n)) == diff && n > 0){
	                diff = Math.abs(100 - (sum + n));
	                sum += n;
	                continue;
	        }
	        break;
	    }
	    System.out.print(sum);
	}
}
