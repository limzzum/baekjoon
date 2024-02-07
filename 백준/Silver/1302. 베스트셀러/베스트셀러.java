import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String answer = "";
        int maxCnt = 0;
        Map<String, Integer> bookCnt = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            bookCnt.put(name, bookCnt.getOrDefault(name, 0) + 1);

            if(bookCnt.get(name) == maxCnt && name.compareTo(answer)<0){
                answer = name;
            }else if(bookCnt.get(name) > maxCnt){
                answer = name;
                maxCnt = bookCnt.get(name);
            }
        }
        System.out.println(answer);
    }
}
