import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
* 아기상어가 먹을 수 있는 물고기의 개수를 미리 알고있기 위해
* 누적합을 이용하여 크기가 n 이하인 물고기의 개수를 저장하는 배열을 만든다.
* -> sum[i] 는 i크기 이하의 물고기 갯수이다.
* 먹을 수 있는 물고기가 있는지 알고 싶다면 sum[아기상어의 크기-1]- 현재까지 먹은 물고기 수가 1이상인지 확인 해준다.
*
*
*
* */

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static BabyShark babyShark;
    static int aliveTime;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static PriorityQueue<BabyShark> pq = new PriorityQueue<>(new Comparator<BabyShark>(){
        @Override
        public int compare(BabyShark o1, BabyShark o2) {
            if(o1.time == o2.time){
                if(o1.r == o2.r){
                    return o1.c - o2.c;
                }
                return o1.r - o2.r;
            }
            return o1.time - o2.time;
        }
    });

    static class BabyShark{
        int r,c;
        int size =2;
        int time;
        int eatCnt;
        int totalEat;
        public BabyShark(int r, int c,int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int[] count = new int[7];
        int[] sumCnt = new int[7];

//        BabyShark babyShark = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    babyShark = new BabyShark(i,j,0);
                    map[i][j] = 0;
                }
                else if(map[i][j]!=0){
                    count[map[i][j]] += 1;
                }
            }
        }

        for (int i = 1; i < 7; i++) {
            sumCnt[i] = count[i]+sumCnt[i-1];
        }


        while (sumCnt[Math.min(6,babyShark.size-1)] - babyShark.totalEat >0){
            int result = eat();
            if(result== -1){
                System.out.println(aliveTime);
                return;
            }
            babyShark.totalEat += 1;
            babyShark.eatCnt += 1;
            if(babyShark.eatCnt == babyShark.size){
                babyShark.eatCnt = 0;
                babyShark.size += 1;
            }
            aliveTime += result;
        }
        System.out.println(aliveTime);

    }
    private static int eat(){
        pq.clear();
        pq.add(babyShark);
        visited = new boolean[N][N];
        visited[babyShark.r][babyShark.c] = true;
        while (!pq.isEmpty()){
            BabyShark poll = pq.poll();
            if(map[poll.r][poll.c] != 0 && map[poll.r][poll.c] < babyShark.size){
                map[poll.r][poll.c] = 0;
                babyShark.r = poll.r;
                babyShark.c = poll.c;

                return poll.time;
            }
            for (int i = 0; i < 4; i++) {
                int nr = poll.r + row[i];
                int nc = poll.c + col[i];

                if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]){
                    continue;
                }
                visited[nr][nc] = true;
                if(map[nr][nc]<= babyShark.size){
                    pq.add(new BabyShark(nr, nc, poll.time+1));
                }
            }

        }
        return -1;
    }
}
