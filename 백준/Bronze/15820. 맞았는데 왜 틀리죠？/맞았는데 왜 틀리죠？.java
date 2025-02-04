import java.util.*;
import java.io.*;

public class Main{
    
    private static int S1, S2;

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S1 = Integer.parseInt(st.nextToken());
        S2 = Integer.parseInt(st.nextToken());
        
        int a, b;
        for(int i=0; i<S1; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a != b){
                System.out.print("Wrong Answer");
                return;
            }
        }
        
        for(int i=0; i<S2; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a != b){
                System.out.print("Why Wrong!!!");
                return;
            }
        }
        System.out.print("Accepted");
	}
	
}
