import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        char[] words = br.readLine().toCharArray();
        boolean isSpecial = false;
        for (char word : words) {
            if(word == '<'){
                isSpecial = true;
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
            if(isSpecial){
                sb.append(word);
                if(word == '>'){
                    isSpecial = false;
                }
                continue;
            }
            if(word == ' '){
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(" ");
                continue;
            }
            stack.add(word);


        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
        
    }

}
