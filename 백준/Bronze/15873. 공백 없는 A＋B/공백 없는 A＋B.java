import java.util.*;
import java.io.*;

public class Main{

    static int N;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        
        if(len == 4){
            System.out.println(20);
            return;
        }
        if(len == 2){
            int num = Integer.parseInt(input);
            System.out.println(num/10 + num % 10);
        }else {
            int A = Integer.parseInt(input.substring(0,1));
            int B = Integer.parseInt(input.substring(1));
            if(input.charAt(1) == '0'){
                A = Integer.parseInt(input.substring(0,2));
                B = Integer.parseInt(input.substring(2));
            }
            System.out.println(A+B);
        }
	}
}
