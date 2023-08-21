import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        double dist = Math.sqrt(Math.pow(X,2) + Math.pow(Y,2));
        double answer = dist;
        
        //점프해서 깔끔하게 갈 수 있어도 그냥 한 칸 씩 걸어가는게 빠를 수 있음
        if(dist%D == 0){
            answer = Math.min(answer, dist/D * T);
            System.out.println(answer);
            return;
        }
       
        answer = Math.min(answer, (int)(dist/D) * T +dist-D*(int)(dist/D));

        answer = Math.min(answer, ((int)(dist/D)+1) * T + (D - (dist-D*(int)(dist/D))));

        //이등변삼각형 최대 밑변 길이구하기.
        double maxLen = Math.sqrt(Math.pow(D,2) - Math.pow(0.000000001,2)) *2;
        dist -=maxLen;
        if(dist%D !=0){
            dist+=D;
        }
        answer = Math.min(answer, (int)(dist/D) * T + T*2);

        System.out.println(answer);



    }
}
