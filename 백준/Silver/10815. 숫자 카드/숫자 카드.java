import java.io.*;
import java.util.*;

public class Main{

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] numCnt = new int[10_000_000];
        int [] numCntMinus = new int[10_000_000];
        String[] nums = br.readLine().split(" ");
        for(String num: nums){
            int n = Integer.parseInt(num);
            if(n>0){
                numCnt[n] = 1;
            }else{
                numCntMinus[-n] = 1;
            }

        }
        int M = Integer.parseInt(br.readLine());
        String[] compare = br.readLine().split(" ");

        for(String com: compare){
            int num = Integer.parseInt(com);
            if(num>0){
                sb.append(numCnt[num]).append(" ");
            }else
            {
                sb.append(numCntMinus[-num]).append(" ");
            }
        }




        System.out.println(sb);
    }
}