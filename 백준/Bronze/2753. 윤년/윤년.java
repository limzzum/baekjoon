import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        if(N%4 == 0 && (N%100 != 0 || N%400 == 0)){
            System.out.print(1);
        }else {
            System.out.print(0);
        }
	}
}
