import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int Tc;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map;

        Tc = Integer.parseInt(st.nextToken());
        for (int i = 0; i < Tc; i++) {
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                map.put(kind, map.getOrDefault(kind, 1)+1);
            }
            int answer = 1;
            for (int value : map.values()){
                answer *= value;
            }
            answer -= 1;
            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }

}
