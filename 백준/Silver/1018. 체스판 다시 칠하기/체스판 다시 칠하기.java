
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String [][] board;
    static int answer = 64;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        board = new String[N][M];
        for(int i=0; i<N; i++){
            String[] line = br.readLine().split("");
            for (int j=0; j<M; j++){
                board[i][j] = line[j];
            }
        }

        for(int i=0; i<=N-8; i++){
            for(int j=0; j<= M-8; j++){
                getCount(i, j);
            }
        }
        System.out.println(answer);
    }
    private static void getCount(int r, int c){
        int count = 0;
        //W ㅅㅣ작
        for(int i=0; i< 8; i++){
            for (int j= 0; j< 8; j++){
                if((i%2==0 && j%2==0) || (i%2==1 && j%2 ==1)){
                    if(board[r+i][c+j].equals("B")){
                        count +=1;
                    }
                }
                if((i%2==0 && j%2==1) || (i%2==1 && j%2 ==0)){
                    if(board[r+i][c+j].equals("W")){
                        count +=1;
                    }
                }
            }
        }
        answer = Math.min(answer, count);
        count = 0;
        for(int i=0; i< 8; i++){
            for (int j= 0; j< 8; j++){
                if((i%2==0 && j%2==0) || (i%2==1 && j%2 ==1)){
                    if(board[r+i][c+j].equals("W")){
                        count +=1;
                    }
                }
                if((i%2==0 && j%2==1) || (i%2==1 && j%2 ==0)){
                    if(board[r+i][c+j].equals("B")){
                        count +=1;
                    }
                }
            }
        }
        answer = Math.min(answer, count);

    }
}
