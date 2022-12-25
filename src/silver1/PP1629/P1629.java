package silver1.PP1629;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1629 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        long a = A % C;
        long b = 1;

        if (a == 0) {
            System.out.println(0);
            return;
        }
        if (B == 1) {
            System.out.println(a);
            return;
        }
        while (B >= 2) {
            if (B % 2 == 1) {
                b = (b * a) % C;
                B -= 1;
            }
            if (B == 2) {
                b = ((a * a) % C * b) % C;
                break;
            }
            B /= 2;
            a = a * a % C;

        }
        System.out.println(b);
    }
}
