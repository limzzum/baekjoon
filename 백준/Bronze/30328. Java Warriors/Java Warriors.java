import java.util.*;
import java.io.*;

class Main{
   
    static int N;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.print(N*4000);
    }
}