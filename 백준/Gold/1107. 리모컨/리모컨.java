import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    static int now = 100;

    static boolean remotecon[] = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int chanel = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        if(n!=0) {
            String temp[] = br.readLine().split(" ");

            for (String str : temp) {
                int broken = Integer.parseInt(str);
                remotecon[broken] = true;
            }
        }

        if(chanel==100)
            System.out.println(0);
        else if(n==10){
            System.out.println(Math.abs(chanel-now));
        }
        else{
            int ans = Math.abs(now-chanel);

        
            for(int i=0;i<1000000;i++){
   
                String number[] = Integer.toString(i).split("");
                boolean flag = true;
                for(String index : number){
                    if(remotecon[Integer.parseInt(index)]) {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans = Math.min(ans,number.length+Math.abs(i-chanel));
                }
            }
            System.out.println(ans);
        }

    }
}