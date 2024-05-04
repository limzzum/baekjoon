import java.util.*;
import java.io.*;

public class Main{

    static int a,b;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        
        System.out.println(b*2 - a);
	}
}
