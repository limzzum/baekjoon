import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        BigInteger answer = a.divide(BigInteger.TWO);

        System.out.println(answer.add(b.divide(BigInteger.TWO)).add(b.remainder(BigInteger.TWO)));
        System.out.println(answer.subtract(b.divide(BigInteger.TWO)));
    }

}
