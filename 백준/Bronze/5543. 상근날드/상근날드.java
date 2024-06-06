import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int answer = -50;
	    int price = 2000;
	    for(int i=0; i<3; i++){
	        price = Math.min(price, Integer.parseInt(br.readLine()));
	    }
	    
	    answer += price;
	    price = 2000;
	    for(int i=0; i<2; i++){
	        price = Math.min(price, Integer.parseInt(br.readLine()));
	    }
	    answer += price;
	    
	    System.out.print(answer);
	}

}
