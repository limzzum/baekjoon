import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

1. 야구 게임 룰을 적용하여 구현한다.
2. 나머지 8명에 대한 순열을 구하고 야구게임을 통해 얻은 점수를 비교하여 최대 점수를 구한다.
 */

public class Main {
    static int N;
    static int[][] result;
    static boolean[] visited = new boolean[9];
    static int answer =0;
    static int debug = 0;

    static class BaseBall{
        int [] ru = new int[4];
        int gameNum = 0;
        int curPlayerIdx;
        int outCnt;
        int score;
        public boolean hitBall(int dist){
            if(dist == 0){
                //System.out.println("out");
                outCnt +=1;
                if(outCnt==3){
                    clear();
                    gameNum +=1;
                    outCnt = 0;
                }
                if(gameNum == N){
                    return false;
                }
                curPlayerIdx = (curPlayerIdx + 1) % 9;
                return true;
            }
            if(dist == 4){
                for (int i=0; i<4; i++){
                    if(ru[i] == 1){
                        score+=1;
                        ru[i] = 0;
                    }
                }
                score +=1;
                curPlayerIdx = (curPlayerIdx + 1) % 9;
                return true;
            }
            for(int i= 4-dist; i<4; i++){
                if(ru[i]==1){
                    ru[i] = 0;
                    score+=1;
                }

            }
            for(int i=3-dist; i>=0; i--){
                if(ru[i] == 1){
                    ru[i] =0;
                    ru[i+dist] = 1;
                }
            }
            ru[dist] = 1;
            curPlayerIdx = (curPlayerIdx + 1) % 9;
            return true;
        }
        public void clear(){
            ru = new int[4];
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        result = new int[N][9];

        for(int i=0; i<N; i++){
            String [] input = br.readLine().split(" ");
            for (int j=0; j<9; j++){
                result[i][j] = Integer.parseInt(input[j]);
            }
        }

        selectOrder(0, new int[9]);
        System.out.println(answer);

    }

    private static void selectOrder(int idx, int[] order){
        if(idx== 3){
            order[idx] = 0;
            selectOrder(idx+1, order);
            return;
        }
        if(idx == 9){
            gameStart(order);
            return;
        }
        for (int i = 1; i<=8; i++){
            if(!visited[i]){
                order[idx] = i;
                visited[i] = true;
                selectOrder(idx+1, order);
                visited[i] = false;
            }
        }
    }

    private static void gameStart(int[] order){
        BaseBall baseBall = new BaseBall();
        while (true){
            if(!baseBall.hitBall(result[baseBall.gameNum][order[baseBall.curPlayerIdx]])){
                answer = Math.max(answer, baseBall.score);
                break;
            }
        }
    }
}
