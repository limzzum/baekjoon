import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    enum Color {
        black(0, 1),
        brown(1, 10),
        red(2, 100),
        orange(3, 1000),
        yellow(4, 10_000),
        green(5, 100_000),
        blue(6, 1_000_000),
        violet(7, 10_000_000),
        grey(8, 100_000_000),
        white( 9, 1_000_000_000);

        final int value;
        final int multi;

        Color(int value, int multi){
            this.value = value;
            this.multi = multi;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Color a = Color.valueOf(br.readLine());
        Color b = Color.valueOf(br.readLine());
        Color c = Color.valueOf(br.readLine());

        long result = Long.parseLong(a.value + "" + b.value);
        result *= c.multi;
        System.out.println(result);
    }
}
