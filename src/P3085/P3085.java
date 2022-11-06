package P3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3085 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] map;
    static int answer=0;
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        //inputRead();

        for(int i = 0; i< N; i++){
            map[i] = br.readLine().toCharArray();
        }
        for(int c=0; c<N; c++){
            for(int r=0; r<N; r++){
                if(N-r<=answer){
                    break;
                }
                answer = Math.max(answer,getLengthUpDown(r, c));
            }

            for(int r=N-1; r>=0; r--){
                if(r<=answer){
                    break;
                }
                answer = Math.max(answer,getLengthDownUp(r, c));
            }
        }


        for(int r=0; r<N; r++){
            for (int c=0; c<N; c++){
                if(N-c<=answer){
                    continue;
                }
                answer = Math.max(answer,getLengthLeftRight(r,c));
            }
            for (int c=N-1; c>=0; c--){
                if(c<=answer){
                    continue;
                }
                answer = Math.max(answer,getLengthRightLeft(r,c));
            }
        }

        System.out.println(answer);
    }

    public static int getLengthUpDown(int r, int c){
        int count=1;
        int chance=1;
        for(int row=r+1; row<N; row++){
            if(map[r][c]== map[row][c]){
                count+=1;
            }
            else if(chance>0){
                if(c-1>=0 && map[r][c] == map[row][c-1]){
                    count+=1;
                    chance-=1;
                }else if(c+1<N && map[r][c] == map[row][c+1]){
                    count+=1;
                    chance-=1;
                } else {
                    break;
                }


            }else{
                break;
            }
        }

        if(chance==1){
            return 1;
        }
        return count;
    }

    public static int getLengthDownUp(int r, int c) throws Exception{
        int count=1;
        int chance=1;
        for(int row=r-1; row>=0; row--){

            if(map[r][c]== map[row][c]){
                count+=1;
            }
            else if(chance>0){
                if(c-1>=0 && map[r][c] == map[row][c-1]){
                    count+=1;
                    chance-=1;
                }else if(c+1<N && map[r][c] == map[row][c+1]){
                    count+=1;
                    chance-=1;
                } else {
                    break;
                }


            }else{
                break;
            }
        }

        if(chance==1){
            return 1;
        }
        return count;
    }

    private static int getLengthLeftRight(int r, int c) {
        int count=1;
        int chance=1;
        for(int col=c+1 ; col<N; col++){
            if(map[r][c] == map[r][col]){
                count+=1;
            }
            else if(chance>0){
                if(r-1>=0 && map[r][c] == map[r-1][col]){
                    count+=1;
                    chance-=1;
                }else if(r+1<N && map[r][c] == map[r+1][col]){
                    count+=1;
                    chance-=1;
                }
                else {
                    break;
                }

            }
            else{
                break;
            }
        }

        if(chance==1){
            return 1;
        }
        return count;
    }

    private static int getLengthRightLeft(int r, int c) {
        int count=1;
        int chance=1;
        for(int col=c-1 ; col>=0; col--){
            if(map[r][c] == map[r][col]){
                count+=1;
            }
            else if(chance>0){
                if(r-1>=0 && map[r][c] == map[r-1][col]){
                    count+=1;
                    chance-=1;
                }else if(r+1<N && map[r][c] == map[r+1][col]){
                    count+=1;
                    chance-=1;
                } else {
                    break;
                }


            }
            else{
                break;
            }
        }
        if(chance==1){
            return 1;
        }
        return count;
    }
    private static void inputRead() throws IOException {
        for(int i = 0; i< N; i++){
            map[i] = br.readLine().toCharArray();
        }
    }
}
