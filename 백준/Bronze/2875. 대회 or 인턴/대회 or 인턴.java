import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        if(N==0 || M == 0){
            System.out.println(0);
            return;
        }

        int teamCnt = Math.min(N/2, M);


         K = K - (N-(2*teamCnt) + M-teamCnt);

        if(K <= 0){
            System.out.println(teamCnt);
            return;
        }

        int minusTeamCnt = K/3 + Math.min(1,K%3);
        int totalTeamCnt = teamCnt - minusTeamCnt;

        System.out.println(totalTeamCnt);
    }
}