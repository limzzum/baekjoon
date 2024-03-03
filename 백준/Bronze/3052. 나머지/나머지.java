import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isUsed = new boolean[42];
        int answer = 0;
        for(int i=0; i<10; i++){
            int num = (Integer.parseInt(br.readLine()))%42;
            if(!isUsed[num]){
                answer += 1;
            }
            isUsed[num] = true;
        }
        System.out.println(answer);
    }
}
