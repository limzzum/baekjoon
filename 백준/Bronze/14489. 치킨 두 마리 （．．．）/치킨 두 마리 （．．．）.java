import java.util.*;
import java.io.*;

public class Main{

    static int A,B;
    static int price;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    A = Integer.parseInt(st.nextToken());
	    B = Integer.parseInt(st.nextToken());
	    A += B;
	    price = Integer.parseInt(br.readLine()) * 2;
	    
	    if(A >= price){
	        A -= price;
	    }
	    System.out.print(A);	    
	}
}
