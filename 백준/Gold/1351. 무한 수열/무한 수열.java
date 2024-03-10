import java.util.*;
import java.io.*;

public class Main {
    
    static long N;
    static int P;
    static int Q;
    static Map<Long, Long> dpMap = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        if(P>Q){
            int temp = P;
            P = Q;
            Q = temp;
        }

        System.out.println(getNum(N));
        
    }
    
    private static long getNum(long n){
        if(dpMap.containsKey(n)){
            return dpMap.get(n);
        }
        
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 2;
        }
        long result = getNum(n/P) + getNum(n/Q);
        dpMap.put(n, result);
        return result;
    }
}