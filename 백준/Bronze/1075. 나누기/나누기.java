
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N = N - (N%100);
        int answer =0;
        if(N%F==0){
            answer = 0;
        }
        else {
            answer = F - N % F;
        }
        String format = String.format("%02d", answer);
        System.out.println(format);

    }
}