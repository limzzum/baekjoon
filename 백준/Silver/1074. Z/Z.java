import java.io.*;

public class Main{
    static int N;
    static int r;
    static int c;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);


        N = (int) Math.pow(2, N);

        dfs(N/2, N/2, N*N, 0);

    }

    private static void dfs( int midR, int midC, int cnt, int sum) {

        cnt /= 4;
        int add = (int) (Math.sqrt(cnt)/2);
        if(cnt == 0) {
            System.out.println(sum);
            return;
        }
        if(r<midR && c<midC) {
            dfs(midR - add, midC - add, cnt, sum);
        }else if(r<midR && c>=midC) {
            dfs(midR - add, midC+add, cnt, sum + cnt);
        }else if(r>= midR && c<midC) {
            dfs(midR+add, midC -add, cnt, sum + cnt*2);
        }else if(r>= midR && c>=midC) {
            dfs(midR+add, midC+add, cnt, sum + cnt*3);
        }

    }
}