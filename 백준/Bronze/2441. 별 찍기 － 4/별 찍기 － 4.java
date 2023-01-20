import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=N; i>0; i--){
            for(int j=0; j<N-i; j++){
                System.out.print(" ");
            }
            for (int k=0; k<i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
