package P6064;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P6064 {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC= Integer.parseInt(br.readLine());
        for(int i=0; i<TC; i++){
            String[] list = br.readLine().split(" ");
            int M = Integer.parseInt(list[0]);
            int N = Integer.parseInt(list[1]);
            int x = Integer.parseInt(list[2]);
            int y = Integer.parseInt(list[3]);

            int unit = M;
            int year = x;

            while(true){
                if(year % M == x % M  && year % N == y % N){
                    sb.append(year+"\n");
                    break;
                }
                year+=M;
                if(year>= M*N){
                    sb.append("-1\n");
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
