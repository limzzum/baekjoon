import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (char c : line) {
                if(c == '('){
                    stack.add(c);
                }else if(!stack.isEmpty()){
                    stack.pop();
                }else {
                    stack.add('F');
                    break;
                }
            }
            if(stack.isEmpty()){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
                stack.clear();
            }

        }

        System.out.println(sb);
    }


}
