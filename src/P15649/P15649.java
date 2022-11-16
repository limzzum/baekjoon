package P15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P15649 {
    static int N;
    static int M;

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

         N = Integer.parseInt(input[0]);
         M = Integer.parseInt(input[1]);

         for (int i=1; i<=N; i++){
            boolean[] visited = new boolean[N+1];
            String answer = ""+i;
            visited[i]=true;
            dfs(1,answer,visited);
         }

    }

    static void dfs(int cnt, String answer, boolean[] visited){

        if(cnt == M){
            System.out.println(answer);
            return;
        }

        for(int i=1; i<=N; i++){
            if(visited[i]){
                continue;
            }
            visited[i]= true;
            dfs(cnt+1, answer+" "+i ,visited);
            visited[i]=false;
        }


    }
}
