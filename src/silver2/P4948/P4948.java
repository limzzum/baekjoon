package silver2.P4948;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P4948 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = 0;

        while (true){
            N = Integer.parseInt(br.readLine());
            if(N==0){
                break;
            }
            int cnt = countDecimal(N);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static int countDecimal(int N) {
        int count = 0;
        for(int i = N+1; i<=N*2; i++){
            if(isDecimal(i)){
                count+=1;
            }
        }
        return count;
    }

    private static boolean isDecimal(int n) {
        if(n==1){
            return false;
        }
        if(n==2){
            return true;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
