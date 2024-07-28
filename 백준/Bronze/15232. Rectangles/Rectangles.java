import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    public static void main(String args[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}