import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());

        if(month == 2 && day == 18){
            System.out.println("Special");
        }else if(month< 2 || (month == 2 && day <18)){
            System.out.println("Before");
        }else {
            System.out.println("After");
        }
    }

}