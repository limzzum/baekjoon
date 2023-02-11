import java.io.*;


 /*
        첫 번째 자리에 올 수 있는 소수는 2, 3, 5, 7 뿐
        2, 3, 5, 7로 시작하는 10의 자리 소수 -> 로 시작하는 100의 자리 소수 ... 로 시작하는 N자리까지 구한다.
 */
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
        /* 
            현재 구한 소수에서 이걸로 시작하는 다음 자릿수까지 구하기 위해 
            현재 소수 * 10 <= X < 현재 소수 *10 + 10 범위에 대해 소수인지 검사를 한다.
            -> 현재 소수가 3 일 경우 30 ~39 까지 숫자 중 탐색.
        */
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