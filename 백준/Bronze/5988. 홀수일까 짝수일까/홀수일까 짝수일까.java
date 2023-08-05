
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            BigInteger num = new BigInteger(br.readLine());
            if(num.mod(new BigInteger("2")).equals(new BigInteger("0"))){
                sb.append("even");
            }else {
                sb.append("odd");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

}