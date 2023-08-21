import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Character,String> map = Map.of(
        'M',"MatKor",
        'W',"WiCys",
        'C',"CyKor",
        'A',"AlKor",
        '$',"$clear");
//    static HashMap<Character,String> map = new HashMap<>(){{
//        put('M',"MatKor");
//        put('W',"WiCys");
//        put('C',"CyKor");
//        put('A',"AlKor");
//        put('$',"$clear");
//
//    }};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char word = br.readLine().charAt(0);
        String ans = map.get(word);
        System.out.println(ans);

    }

}