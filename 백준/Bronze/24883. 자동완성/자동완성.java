import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if(input.toLowerCase().equals("n")){
            System.out.println("Naver D2");
            return;
        }
        System.out.println("Naver Whale");
    }
}