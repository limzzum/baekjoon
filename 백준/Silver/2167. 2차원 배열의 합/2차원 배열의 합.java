import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[][] sumBoard;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M+1];
        sumBoard = new int[N+1][M+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                sumBoard[i][j] = sumBoard[i][j-1] + board[i][j];
                if(j == M){
                    sumBoard[i+1][0] = sumBoard[i][j];
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken()) -1;
            int startC = Integer.parseInt(st.nextToken()) ;
            int endR = Integer.parseInt(st.nextToken()) -1;
            int endC = Integer.parseInt(st.nextToken()) ;
            int ans = 0;
            for (int j = startR; j <= endR; j++) {
                ans += sumBoard[j][endC] - sumBoard[j][startC-1];
            }
            sb.append(ans);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
