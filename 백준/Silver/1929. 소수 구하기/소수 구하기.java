import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i=N; i<=M; i++){
            if(isDecimal(i)){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isDecimal(int num) {
        if(num == 1){
            return false;
        }
        if(num == 2){
            return true;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i ==0){
                return false;
            }
        }
        return true;
    }
}
