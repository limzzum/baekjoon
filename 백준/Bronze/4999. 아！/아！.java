import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String me = br.readLine();
        String doctor = br.readLine();
        if(me.length()>=doctor.length()){
            System.out.println("go");
        }else{
            System.out.println("no");
        }
    }
}
