package etc.P1476;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1476 {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int one = Integer.parseInt(input[0]);
        int two = Integer.parseInt(input[1]);
        int three = Integer.parseInt(input[2]);

        int MaxOne = 15;
        int MaxTwo = 28;
        int MaxThree = 19;

        int year = two;
        while (true){
            if(year % MaxOne == one % MaxOne && year % MaxTwo == two % MaxTwo && year % MaxThree == three % MaxThree){
                break;
            }
            year+= MaxTwo;
        }
        System.out.println(year);
    }
}
