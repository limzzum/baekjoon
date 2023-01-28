import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Integer> circle = new ArrayList<>();
        for(int i=1; i<=N; i++){
            circle.add(i);
        }
        sb.append("<");
        int idx = K;
        for(int i=0; i<N; i++){
            int removed = circle.remove(idx - 1);
            sb.append(removed);

            if(i==N-1){
                break;
            }
            idx = (idx+K-1) % circle.size();
            if(idx==0){
                idx= circle.size();
            }
            sb.append(", ");
        }
        sb.append(">");

        System.out.println(sb);


    }


}
