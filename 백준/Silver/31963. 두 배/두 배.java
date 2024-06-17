import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pre = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            while(num < pre){
                num *= 2;
                answer += 1;
            }
            pre = num;
        }
        
        System.out.print(answer);
    }
}
