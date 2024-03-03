import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger year = new BigInteger(br.readLine());
        BigInteger n = new BigInteger(br.readLine());
        System.out.println(year.add(n));

    }
}