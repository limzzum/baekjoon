import java.io.*;

public class Solution{
    static int [] row = {0,1,0,-1};
    static int [] col = {1,0,-1,0};

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            int n = 2;
            int r = 0;
            int c = 0;
            map[r][c] = 1;
            visited[r][c] = true;
            int idx = 0;
            int nexR;
            int nexC;
            while(n<=N*N){
                nexR = r+row[idx];
                nexC = c+col[idx];
                if(nexR>=0 && nexR <N && nexC >=0 && nexC <N && !visited[nexR][nexC]){
                    map[nexR][nexC] = n;
                    r += row[idx];
                    c += col[idx];
                    visited[nexR][nexC]= true;
                    n+=1;
                }else{
                    idx= (idx+1) % 4;
                }
                
            }
            sb.append("#"+i);
            for(int[] R:map){
                sb.append("\n");
                for(int C: R){
                    sb.append(C+" ");
                }
            }
            sb.append("\n");

        }
        System.out.println(sb);


    }
}