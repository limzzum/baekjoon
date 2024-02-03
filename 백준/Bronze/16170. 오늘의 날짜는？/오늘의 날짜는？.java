import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDateTime;

public class Main{
    public static void main(String[] args) throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now().minusHours(9);
        System.out.println(localDateTime.getYear());

        System.out.println(String.format("%02d",localDateTime.getMonth().getValue()));
        System.out.println(String.format("%02d",localDateTime.getDayOfMonth()));
    }
}