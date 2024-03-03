import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int price = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
                int pay = Integer.parseInt(st.nextToken());
        if(price*cnt -pay <= 0){
                    System.out.println(0);
            return;
}
         System.out.println(price*cnt-pay);
    }
}