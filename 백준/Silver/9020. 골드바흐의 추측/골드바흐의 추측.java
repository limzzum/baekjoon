

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            int[] answer = findAnswer(num, num / 2);
            sb.append(answer[0]+" "+answer[1]).append("\n");
        }
        System.out.println(sb);
    }

    private static int[] findAnswer(int origin, int part) {
        if(isDecimal(part) && isDecimal(origin - part)){
            return new int[]{part, origin -part};
        }
        return findAnswer(origin,part-1);
    }

    private static boolean isDecimal(int num) {
        if(num ==1){
            return false;
        }
        if(num == 2){
            return true;
        }
        for(int i=2; i<= Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
