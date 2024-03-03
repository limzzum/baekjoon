

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int count;
    static int N;
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int Tc = Integer.parseInt(br.readLine());

        for(int i=0; i<Tc; i++){
            count =0;
            N = Integer.parseInt(br.readLine());
            dfs(0);
            sb.append(count+"\n");
        }

        System.out.println(String.valueOf(sb));
    }

    private static void dfs(int sum) {
        if(sum == N){
            count += 1;
            return;
        }
        if(sum> N){
            return;
        }

        dfs(sum+1);
        dfs(sum+2);
        dfs(sum+3);

    }
}
