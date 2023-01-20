import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        String[] aArray = br.readLine().split(" ");
        String[] bArray = br.readLine().split(" ");

        int i = 0;
        int j = 0;

        while(i<a || j<b) {
            if(i==a){
                sb.append(bArray[j]).append(" ");
                j+=1;
                continue;
            }
            if(j==b){
                sb.append(aArray[i]).append(" ");
                i+=1;
                continue;
            }

            if(Integer.parseInt(aArray[i])<=Integer.parseInt(bArray[j]) ){
                sb.append(aArray[i]).append(" ");
                i+=1;
            }else{
                sb.append(bArray[j]).append(" ");
                j+=1;
            }
        }

        System.out.println(sb);
    }
}
