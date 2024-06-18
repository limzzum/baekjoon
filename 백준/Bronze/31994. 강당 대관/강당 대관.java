import java.util.*;
import java.io.*;

public class Main{

    static int max;
    static String name;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        for(int i=0; i<7; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            
            if(b > max){
                max = b;
                name = a;
            }
        }
        
        System.out.print(name);
    }
    
}
