import java.io.*;

public class Main{
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine().charAt(0)-'0';
        int [] decimal = {2,3,5,7};

        for(int i=0; i<decimal.length; i++){
            dfs(1, decimal[i]);
        }
        System.out.println(sb);
    }
    private static void dfs(int cnt, int ans){

        if(cnt == N){
            sb.append(ans).append("\n");
            return;
        }

        for(int i= ans*10 ; i<ans*10+10; i++){
            if(isDecimal(i)){
                dfs(cnt+1, i);
            }
        }
    }
    private static boolean isDecimal(int num){
        if(num == 1){
            return false;
        }
        if(num == 2){
            return true;
        }
        for(int i=2; i<= Math.sqrt(num); i++){
            if(num% i == 0){
                return false;
            }
        }
        return true;
    }
}