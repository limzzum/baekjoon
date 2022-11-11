package P1748;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1748 {
    static int answer;
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        answer = getAnswer(N) ;

        System.out.println(answer);

    }

    private static int getAnswer(String N) {
        int len = N.length();
        if(len==1){
            answer = Integer.parseInt(N);
            return answer;
        }

        for(int i = 1; i<len; i++){
            answer += Math.pow(10,i-1) * i*9;
        }

        answer += len * (Integer.parseInt(N) - Math.pow(10,len -1) +1);
        return answer;
    }
}
