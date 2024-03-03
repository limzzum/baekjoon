import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
// 어디갔을가.. 임정현.. 그녀의 위치가 정말 궁금한 시점입니다.
// 도저히 폭탄 돌리기를 어떻게 해야할지 모르겠어요.
//
public class Main {
    static char [][] map;
    static char [][] exploded;
    static boolean[][] removed;
    static int R;
    static int C;
    static Queue<Bomb> bombs = new ArrayDeque<>();
    static class Bomb{
        int r,c;
        public Bomb(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]);

        map = new char[R][C];
        exploded = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'O'){
                    bombs.add(new Bomb(i,j));
                }
            }
        }
        if(N == 1){
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            return;
        }if(N%2==0){
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print('O');
                }
                System.out.println();
            }
            return;
        }else{

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    exploded[i][j] = 'O';
                }
            }

            explode();
            if((N)%4 == 3){
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(exploded[i][j]);
                }
                System.out.println();
            }
            return;
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(exploded[i][j] == 'O'){
                        bombs.add(new Bomb(i,j));
                    }
                    exploded[i][j] = 'O';
                }
            }

            explode();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(exploded[i][j]);
                }
                System.out.println();
            }
        }

    }

    private static void explode() {

        while (!bombs.isEmpty()) {

            Bomb bomb = bombs.poll();
            exploded[bomb.r][bomb.c] = '.';

            if (bomb.r - 1 >= 0) {
                exploded[bomb.r - 1][bomb.c] = '.';
            }
            if (bomb.r + 1 < R) {
                exploded[bomb.r + 1][bomb.c] = '.';
            }
            if (bomb.c - 1 >= 0) {
                exploded[bomb.r][bomb.c - 1] = '.';
            }
            if (bomb.c + 1 < C) {
                exploded[bomb.r][bomb.c + 1] = '.';
            }
        }

    }

    private static void install(int time){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == '.'){
                    map[i][j] = 'O';
                    bombs.add(new Bomb(i,j));
                }
            }
        }
    }
}
