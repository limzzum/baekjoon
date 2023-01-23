import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final Map<String, int[]> dir = new HashMap(){{
        put("1", new int[]{-1, 0});
        put("2", new int[]{1,0});
        put("3",new int[]{0,1});
        put("4",new int[]{0,-1});

    }};

    static class Shark{
        int r;
        int c;
        int speed;
        String direction;
        int size;

        public Shark(int r, int c, int speed, String direction, int size){
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }
    static class Water{
        Shark [][] map;

        public Water(int R, int C){
            this.map = new Shark[R][C];
        }
        public void move(){
            Queue<Shark> qp = new LinkedList<>();
            for(int i=1; i<map.length; i++){
                for(int j=1; j<map[i].length; j++){
                    if(map[i][j]!=null && map[i][j].speed !=0){
                        qp.add(map[i][j]);
                        map[i][j] = null;
                    }
                }
            }

            while(!qp.isEmpty()){
                Shark poll = qp.poll();
                swim(poll);
            }
        }

        private void swim(Shark shark){
            int r = map.length-1;
            int c = map[0].length-1;

            shark.r += (dir.get(shark.direction)[0]*shark.speed);
            shark.c += (dir.get(shark.direction)[1]*shark.speed);

            while(shark.r>r || shark.r <1){
                if(shark.r>r){
                    shark.r = r - (shark.r - r);
                    shark.direction = "1";
                }
                if(shark.r<1){
                    shark.r = 1 + (1-shark.r);
                    shark.direction = "2";
                }
            }
            while(shark.c >c || shark.c <1){
                if(shark.c>c){
                    shark.c = c - (shark.c - c);
                    shark.direction = "4";
                }
                if(shark.c<1){
                    shark.c = 1 + (1-shark.c);
                    shark.direction = "3";
                }
            }

            if(map[shark.r][shark.c] != null && map[shark.r][shark.c].size>shark.size){
                return;
            }
            map[shark.r][shark.c] = shark;
        }
        public int fishing(int col){
            for(int i=1; i<map.length; i++){
                if(map[i][col]!=null){
                    int size = map[i][col].size;
                    map[i][col] = null;
                    return size;
                }
            }
            return 0;
        }
        public void add(Shark shark){
            map[shark.r][shark.c] = shark;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);

        Water water = new Water(R+1,C+1);

        for(int i=0; i<M; i++){
            String[] info = br.readLine().split(" ");
            int r = Integer.parseInt(info[0]);
            int c = Integer.parseInt(info[1]);
            int s = Integer.parseInt(info[2]);
//            int d = Integer.parseInt(info[3]);
            int z = Integer.parseInt(info[4]);
            water.add(new Shark(r,c,s,info[3],z));
        }

        int sum = 0;
        for(int i=1; i<=C; i++){
            sum += water.fishing(i);
            water.move();
        }
        System.out.println(sum);
    }
}
