import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word;
        while((word = br.readLine())!= null){
            System.out.println(word);
        }
    }}