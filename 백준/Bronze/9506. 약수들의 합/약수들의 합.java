import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int N = Integer.parseInt(br.readLine());
            if(N== -1){
                break;
            }

            StringBuilder answer = getAnswer(N);
            if(answer == null){
                System.out.println(N+" is NOT perfect.");
            }else{
                System.out.println(answer);
            }
        }


    }
    private static StringBuilder getAnswer(int num){
        StringBuilder sb = new StringBuilder();
        sb.append(num).append(" ").append("= 1");
        int sum = 1;
        for (int i = 2; i <= num/2; i++) {
            if(num % i == 0){
                sum += i;
                sb.append(" + ").append(i);
            }
        }
        if(sum == num){
            return sb;
        }
        return null;
    }
}