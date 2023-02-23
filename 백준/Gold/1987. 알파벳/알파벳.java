import java.io.*;

public class Main{
    static int [] row = {0, -1, 0, 1};
    static int[] col = {-1,0,1,0};
    static int N;
    static int M;
    static String[][] map;
    static int answer;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);


        map = new String[N][M];
        for (int i=0; i<N; i++){
            map[i] = br.readLine().split("");
        }

        dfs(0,0,map[0][0]);
        System.out.println(answer);

    }
    private static void dfs(int r, int c, String ans){

        for (int i=0; i<4; i++){
            int nexR = r + row[i];
            int nexC = c + col[i];
            if(nexR>=0 && nexR<N && nexC>=0 && nexC <M){
                if(!ans.contains(map[nexR][nexC])){
                    dfs(nexR, nexC, ans+map[nexR][nexC]);
                }else {
                    answer = Math.max(answer, ans.length());
                }
            }
        }
    }
}