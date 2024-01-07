import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final String JUNIOR = "Junior";
    static final String SENIOR = "Senior";
    static final int MAX_AGE = 17;
    static final int MAX_WEIGHT = 80;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(name.equals("#")){
                break;
            }
            sb.append(name).append(" ");
            if(age> MAX_AGE || weight >= MAX_WEIGHT){
                sb.append(SENIOR);
            }else{
                sb.append(JUNIOR);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
