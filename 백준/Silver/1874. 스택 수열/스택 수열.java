import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int cur = 0;
        boolean[] isUsed = new boolean[N+1];
        
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > cur){
                for(int j= cur +1; j <= num; j++){
                    if(isUsed[j]){
                        continue;
                    }
                    sb.append("+").append("\n");
                }
                sb.append("-").append("\n");
                cur = num;
            }else {
                for(int j=cur -1; j>0; j--){
                    if(!isUsed[j]){
                        if(j != num){
                            System.out.println("NO");
                            return;
                        }
                        sb.append("-").append("\n");
                        cur = j;
                        break;
                    }
                }

            }
            isUsed[num] = true;
        }
        
        System.out.println(sb);
    }
}