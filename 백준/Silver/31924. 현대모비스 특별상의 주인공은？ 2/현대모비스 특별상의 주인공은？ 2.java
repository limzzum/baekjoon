import java.util.*;
import java.io.*;

public class Main{
    
    static final String target = "MOBIS";
    static final int[] row = {0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] col = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int N;
    static char[][] map;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        
        if(N < 5){
            System.out.print(0);
            return;
        }
        
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'M'){
                    answer += getCount(i, j);
                }
            }
        }
        System.out.print(answer);
        
    }
    
    private static int getCount(int r, int c){
        int cnt = 0;
        for(int i=0; i<8; i++){
            if(isMobis(r, c, i)){
                cnt += 1;
            }
        }
        return cnt;
    }
    
    private static boolean isMobis(int r, int c, int direction){
        int nr = r;
        int nc = c;
        for(int i=1; i<5; i++){
            nr += row[direction];
            nc += col[direction];
            if(nr < 0 || nr >= N || nc < 0 || nc >= N){
                return false;
            }
            if(map[nr][nc] != target.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
