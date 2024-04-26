import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        int sum = a + b + c;
        if(sum != 180){
            System.out.println("Error");
            return;
        }
        
        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);

        if(set.size() == 1){
            System.out.println("Equilateral");
        }else if(set.size() == 2){
            System.out.println("Isosceles");
        }else {
            System.out.println("Scalene");

        }
	}
}
