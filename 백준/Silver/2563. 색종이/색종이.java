import java.io.*;

public class Main{

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][] map = new int[100][100];
        int count = 0;
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int c = Integer.parseInt(input[0]);
            int r = 99 - Integer.parseInt(input[1]);

            for(int row = r; row > r-10; row--){
                for(int col = c; col< c+10; col++){
                    if (map[row][col] == 0) {
                        count +=1;
                        map[row][col] = 1;
                    }
                }
            }
        }
        System.out.println(count);

    }
}