import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();
        String[] line = br.readLine().split("");

        leftStack.addAll(Arrays.asList(line));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String[] command= br.readLine().split(" ");
            if(command[0].equals("L")){
                if(!leftStack.isEmpty()){
                    rightStack.add(leftStack.pop());
                }
            }
            else if(command[0].equals("D")){
                if(!rightStack.isEmpty()){
                    leftStack.add(rightStack.pop());
                }
            }
            else if(command[0].equals("B")){
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }
            }
            else if(command[0].equals("P")){
                leftStack.add(command[1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!leftStack.isEmpty()){
            rightStack.add(leftStack.pop());
        }
        while (!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}
