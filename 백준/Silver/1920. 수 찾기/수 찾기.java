import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        for (String s : line) {
            map.put(s,1);
        }
        int M = Integer.parseInt(br.readLine());
        String[] line2 = br.readLine().split(" ");

        for (String s : line2) {
            if(map.containsKey(s)){
                sb.append(map.get(s));
            }
            else{
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
