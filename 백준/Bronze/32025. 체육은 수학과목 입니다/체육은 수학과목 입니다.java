import java.util.*;
import java.io.*;

public class Main{
    
    static int R;

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(br.readLine());
        R = Math.min(R, Integer.parseInt(br.readLine()));
        R = (int) (R/2.0 * 100);
        System.out.print(R);
	}
}
