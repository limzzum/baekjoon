import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static double startTime;
    static double endTime;
    static double streamingEndTime;
    static Map<String, Double> enterMember = new HashMap<>();
    static int answer;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        startTime = Double.parseDouble(st.nextToken().replace(":","."));
        endTime = Double.parseDouble(st.nextToken().replace(":","."));
        streamingEndTime = Double.parseDouble(st.nextToken().replace(":","."));

        double time;
        String name;
        while ((name = br.readLine()) != null){
            st = new StringTokenizer(name);
            time = Double.parseDouble(st.nextToken().replace(":","."));
            name = st.nextToken();
            if(isEnterTime(time)){
                enterMember.put(name, time);
            }else if(isOutTime(time)){
                if(enterMember.containsKey(name)){
                    answer += 1;
                    enterMember.remove(name);
                }
            }
        }

        System.out.println(answer);

    }

    private static boolean isEnterTime(double time){
        return time <= startTime;
    }

    private static boolean isOutTime(double time){
        return time >= endTime && time <= streamingEndTime;
    }




}
