import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        int S = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("all")){
                S = (1<<21) - 1;
            }else if(command.equals("empty")){
                S = 0;
            }else {
                int n = Integer.parseInt(st.nextToken());
                if (command.equals("add")) {
                    S = S | 1 << n;
                } else if (command.equals("check")) {
                    if ((S & 1 << n) > 0) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                } else if (command.equals("remove")) {
                        S = S & ~(1 << n);

                } else if (command.equals("toggle")) {
                    S = S ^ 1 << n;
                }
            }
        }
        System.out.println(sb);
    }
}
