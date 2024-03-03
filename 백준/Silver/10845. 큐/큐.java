
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> qp = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String line = br.readLine();
            if(line.contains("push")){
                int n = Integer.parseInt(line.split(" ")[1]);
                qp.add(n);
            }
            if(line.equals("pop")){
                if(!qp.isEmpty()){
                    sb.append(qp.poll()).append("\n");
                }
                else {
                    sb.append(-1).append("\n");
                }
            }
            if(line.equals("size")){
                sb.append(qp.size()).append("\n");
            }
            if(line.equals("empty")){
                if(qp.isEmpty()){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }

            }
            if(line.equals("front")){
                if(!qp.isEmpty()){
                    sb.append(qp.peek()).append("\n");
                }
                else {
                    sb.append(-1).append("\n");
                }
            }
            if(line.equals("back")){
                if(!qp.isEmpty()){
                    sb.append(qp.peekLast()).append("\n");
                }
                else {
                    sb.append(-1).append("\n");
                }
            }

        }
        System.out.println(sb);


    }
}
