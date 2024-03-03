import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = "WelcomeToSMUPC";
        int N = Integer.parseInt(br.readLine());
        if(N==0){
            System.out.println("W");
            return;
        }
        N%= 14;
        if(N==0){
            System.out.println("C");
            return;
        }

        System.out.println(word.charAt(N-1));

        
    }

}
