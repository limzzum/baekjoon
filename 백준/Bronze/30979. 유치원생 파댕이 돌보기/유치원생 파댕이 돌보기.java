import java.util.*;
import java.io.*;

public class Main{

    static int T, N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=0; i<N; i++){
            sum += Integer.parseInt(st.nextToken());
        }
        
        if(sum >= T){
            System.out.print("Padaeng_i Happy");
        }else{
            System.out.print("Padaeng_i Cry");
        }
    } 
}
