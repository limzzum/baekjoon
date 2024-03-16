import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        
        System.out.println(x + y + 3);
    }
}
