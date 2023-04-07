import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int M;
    static String[][] map;
    static int[][] countMap;
    static int[] row = {0, 0, 1, -1};
    static int[] col = {1, -1, 0, 0};
    static int num=1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new String[N][M];
        countMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i,j);
                if(countMap[i][j] == num){
                    num++;
                }
            }
        }
        System.out.println(num-1);


    }

    private static int dfs(int r, int c){
        countMap[r][c] = num;
        if(map[r][c].equals("D")){
            if(countMap[r+1][c] !=0){
                return countMap[r][c] = countMap[r+1][c];
            }
            countMap[r][c] = dfs(r+1,c);
        }
        else if(map[r][c].equals("L")){
            if(countMap[r][c-1] !=0){
                return countMap[r][c] = countMap[r][c-1];

            }
            countMap[r][c] =dfs(r,c-1);
        }
        else if(map[r][c].equals("R")){
            if(countMap[r][c+1] !=0){
                return countMap[r][c] = countMap[r][c+1];
            }
            countMap[r][c] =dfs(r,c+1);
        }
        else if(map[r][c].equals("U")){
            if(countMap[r-1][c] !=0){
                return countMap[r][c] = countMap[r-1][c];

            }
            countMap[r][c] =dfs(r-1,c);
        }
        return countMap[r][c];
    }
}
