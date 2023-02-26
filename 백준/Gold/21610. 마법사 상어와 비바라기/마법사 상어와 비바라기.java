import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
* 8방 탐색 static 변수 선언.
* 처음 구름의 위치 = N-2, 0 -> 구름의 크기는 2x2이고 왼쪽 위 끝부분으로 위치 고정.
* M의 크기만큼 배열 생성하여 입력받고 이동 시작.
* 크기는 %연산을 이용하여 N-1을 넘지 않도록 설정. 이동한 좌표가 -일경우 -만큼 N에서 빼줌.
* 구름이 이동한 위치에 크기를 +1해주고 범위내의 대각선 4곳에서 1이상인 경우 만큼 +해줌.
* 증가한 칸은 임시 체크를 해줌.
* 증가한 칸을 제외하여 나머지 곳에서 양이 2이상인 경우 -2를 시키고 구름생성.
* 구름 클래스를 만들어 관리. 구름의 시작좌표(왼쪽 위끝)과 크기를 저장.
* map클래스를 만들의 구름들을 관리하고 move메서드를 여기서 작성한다.
* ====> 처음생각이고 변화있음
 * */
public class Main {
    static int N;
    static int M;
    static int count;
    static int[] row = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] col = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] crossR = {-1, -1, 1, 1};
    static int[] crossC = {-1, 1, -1, 1};
    static int [][] isCloud;
    static int[][] map;

    static class Sky{
        private Queue<Cloud> clouds;
        private List<Cloud> removed;

        public Sky(){
            clouds = new LinkedList<>();
            removed = new ArrayList<>();
            clouds.add(new Cloud(N-2,0));
            clouds.add(new Cloud(N-2,1));
            clouds.add(new Cloud(N-1,0));
            clouds.add(new Cloud(N-1,1));
        }

        public void addCloud(Cloud cloud){
            clouds.add(cloud);
        }
        public void moveClouds(int dir, int cnt){
            cnt = cnt % N;
            int len = clouds.size();
            for(int i=0; i<len; i++){
                Cloud poll = clouds.poll();
                poll.r = (poll.r + row[dir]*cnt) % N;
                poll.c = (poll.c + col[dir]*cnt) % N;
                if(poll.r <0){
                    poll.r = N + poll.r;
                }
                if(poll.c<0){
                    poll.c = N + poll.c;
                }
                removed.add(poll);
                isCloud[poll.r][poll.c] = count;

                raining(poll.r, poll.c);

            }
        }

        public void raining(int r, int c){
            map[r][c] += 1;
        }

        public void copyWater(){
            for (int I = 0; I<removed.size(); I++){
                int r = removed.get(I).r;
                int c = removed.get(I).c;
                for (int i = 0; i<4; i++){
                    int nexR = r + crossR[i];
                    int nexC = c + crossC[i];
                    if(nexR>=0 && nexR<N && nexC>=0 && nexC<N){
                        if(map[nexR][nexC]>0 ){
                            map[r][c] +=1;
                        }
                    }
            }

            }
            removed.clear();
        }

        public void createCloud(){
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    if(isCloud[i][j] != count && map[i][j] >=2){
                        addCloud(new Cloud(i,j));
                        map[i][j] -=2;
                    }
                }
            }
        }
    }
    static class Cloud{
        int r;
        int c;

        public Cloud(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][N];
        isCloud = new int[N][N];

        for (int i= 0; i<N; i++){
            String [] line = br.readLine().split(" ");
            for (int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        Sky sky = new Sky();

        for (int i=0; i<M; i++){
            count = i+1;
            String [] command = br.readLine().split(" ");
            int dir = Integer.parseInt(command[0]);
            int cnt = Integer.parseInt(command[1]);
            sky.moveClouds(dir, cnt);
            sky.copyWater();
            sky.createCloud();

        }
        int sum = 0;
        for (int i=0; i<N; i++){
            for (int j =0; j<N; j++){
                sum += map[i][j];
            }
        }
        System.out.println(sum);

    }
}