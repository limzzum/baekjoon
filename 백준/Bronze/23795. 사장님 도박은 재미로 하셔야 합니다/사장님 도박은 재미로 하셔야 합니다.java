import java.util.*;
import java.io.*;

public class Main{

    static int answer;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == -1){
                break;
            }
            answer += n;
        }
        
        System.out.print(answer);
        
	}
}
