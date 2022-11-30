package P1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1912 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[input.length];
        numbers[0]= Integer.parseInt(input[0]);

        for (int i=1; i<N; i++){
            numbers[i] = numbers[i-1]+ Integer.parseInt(input[i]);
        }

        int max = -1001;
        int minus = 0;
        for (int num : numbers) {
            if(num-minus > max){
                max = num-minus;
            }
            if(num<0 && num<minus){
                minus = num;
            }
        }


        System.out.println(max);
    }
}
