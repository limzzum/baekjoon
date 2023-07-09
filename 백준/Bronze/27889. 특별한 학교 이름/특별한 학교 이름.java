import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, String> map = new HashMap<>(){{
        put("NLCS","North London Collegiate School");
        put("BHA","Branksome Hall Asia");
        put("KIS", "Korea International School");
        put("SJA","St. Johnsbury Academy");
    }};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(map.get(input));
    }
}