import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String,String> cheer = new HashMap<>(){{
        put("SONGDO","HIGHSCHOOL");
        put("CODE", "MASTER");
        put("2023", "0611");
        put("ALGORITHM", "CONTEST");
    }};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(cheer.get(input));

    }
}
