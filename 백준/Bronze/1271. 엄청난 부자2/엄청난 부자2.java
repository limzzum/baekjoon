import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger money = new BigInteger(st.nextToken());
        BigInteger cnt = new BigInteger(st.nextToken());

        BigInteger divide = money.divide(cnt);
        BigInteger mod = money.mod(cnt);
        System.out.println(divide);
        System.out.println(mod);

    }
}