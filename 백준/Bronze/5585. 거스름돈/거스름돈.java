import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        money = 1000 - money;

        int cnt = 0;
        cnt += money/500;
        money %= 500;

        cnt += money/100;
        money %= 100;

        cnt += money/50;
        money %= 50;

        cnt += money/10;
        money %= 10;

        cnt += money/5;
        money %= 5;

        cnt += money/1;
        System.out.println(cnt);
    }
}