import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static final int BIG_SIZE = 8;
    static final int SMALL_SIZE = 3;
    static final int STUDENT_NUM = 28;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bigCnt = Integer.parseInt(br.readLine());
        int smallCnt = Integer.parseInt(br.readLine());

        int total = bigCnt * BIG_SIZE + smallCnt * SMALL_SIZE;

        if(total <= STUDENT_NUM){
            System.out.println(0);
            return;
        }
        System.out.println(total - STUDENT_NUM);
    }

}
