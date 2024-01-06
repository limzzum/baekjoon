import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static final int MIN_UPPER_CASE_ASCII_CODE = 65;
    static final int MAX_UPPER_CASE_ASCII_CODE = 90;
    static final int MIN_LOW_CASE_ASCII_CODE = 97;
    static final int MAX_LOW_CASE_ASCII_CODE = 122;
    static final int UPPER_LOW_DIFF = 32;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] words = br.readLine().toCharArray();
        for (char word : words) {
            if(word <= MAX_UPPER_CASE_ASCII_CODE){
                bw.write(word+ UPPER_LOW_DIFF);
            }else{
                bw.write(word - UPPER_LOW_DIFF);
            }
        }

        bw.flush();
        bw.close();
    }

}
