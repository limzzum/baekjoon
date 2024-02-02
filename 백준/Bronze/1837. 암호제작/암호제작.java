import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    private static final BigInteger ZERO = BigInteger.valueOf(0);
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger block = new BigInteger(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=2; i < K; i++) {
            if(block.remainder(BigInteger.valueOf(i)).equals(ZERO) && isDecimal(i)) {
                    System.out.println("BAD "+i);
                    return;
                }
        }
        System.out.println("GOOD");

    }

    private static boolean isDecimal(int num) {
        if(num == 2) {
            return true;
        }
        for(int i=2; i <= Math.sqrt(num); i++) {
            if(num %i == 0) {
                return false;
            }
        }
        return true;
    }
}