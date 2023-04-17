import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int hour = Integer.parseInt(input[0]);
        int minute = Integer.parseInt(input[1]);

        int add = Integer.parseInt(br.readLine());

        int addHour = add / 60;
        int addMinute = add % 60;

        minute += addMinute;
        addHour += minute/60;
        minute %= 60;

        hour += addHour;
        hour %=24;

        System.out.println(hour+" "+minute);
    }
}
