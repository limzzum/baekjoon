import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String line = br.readLine();
            if(line.contains("push")){
                int n = Integer.parseInt(line.split(" ")[1]);
                stack.add(n);
            }
            if(line.equals("pop")){
                if(!stack.isEmpty()){
                    sb.append(stack.pop()).append("\n");
                }
                else {
                    sb.append(-1).append("\n");
                }
            }
            if(line.equals("size")){
                sb.append(stack.size()).append("\n");
            }
            if(line.equals("empty")){
                if(stack.isEmpty()){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }

            }
            if(line.equals("top")){
                if(!stack.isEmpty()){
                    sb.append(stack.peek()).append("\n");
                }
                else {
                    sb.append(-1).append("\n");
                }
            }


        }
        System.out.println(sb);
    }
}
