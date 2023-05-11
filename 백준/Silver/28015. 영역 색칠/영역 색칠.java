import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int pre = 0;
            int [] color = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(pre == num){
                    continue;
                }
                if(num == 0){
                    if(color[1]== 0 || color[2]==0){
                        answer += 1;
                    }else {
                        answer += Math.min(color[1], color[2])+1;
                    }
                    color[1]=0;
                    color[2] =0;
                    pre = num;
                    continue;
                }

                    color[num] +=1;
                    pre = num;


            }
            if(pre !=0){
                if(color[1]== 0 || color[2]==0){
                    answer += 1;
                }else {
                    answer += Math.min(color[1], color[2])+1;
                }
            }
        }
        System.out.println(answer);

    }
}
