import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (N>1){
            for (int i = 0, idxR=0; i < N; i+=2, idxR++) {
                for (int j = 0, idxC=0 ; j < N; j+=2, idxC++) {
                    int a = Math.max(Math.min(map[i][j], map[i][j+1]), Math.min(map[i+1][j], map[i+1][j+1]));
                    int b = Math.min(Math.max(map[i][j],map[i][j+1]),Math.max(map[i+1][j], map[i+1][j+1]));
                    int second = Math.max(a,b);
                    map[idxR][idxC] = second;
                }
            }
            N/=2;
        }
        System.out.println(map[0][0]);


    }
}
