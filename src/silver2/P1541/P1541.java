package silver2.P1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class P1541 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern pt = Pattern.compile("[-+]");
        Pattern compile = Pattern.compile("[^-+]+");

        String input = br.readLine();
        String[] numbers =input.split(String.valueOf(pt));
        String[] operator = input.replaceAll(String.valueOf(compile), "").split("");
        int idx = 1;
        for (String op : operator) {
            if(op.equals("-")){
                break;
            }
            idx += 1;
        }
        int sum = 0;
        for (int i = 0; i< numbers.length; i++) {
            if(i>=idx){
                sum -= Integer.parseInt(numbers[i]);
                continue;
            }
            sum += Integer.parseInt(numbers[i]);

        }
        System.out.println(sum);
    }
}
