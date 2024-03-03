import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> qp = new LinkedList<>();

        int [] x = {0,-1,0,1,0,0};
        int [] y = {-1,0,1,0,0,0};
        int [] z = {0,0,0,0,1,-1};
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[0]);
        int H = Integer.parseInt(input[2]);

        int [][][] map = new int[H][N][M];
        int amount = H*N*M;
        for(int i=0; i<H; i++){
            for (int j=0; j<N; j++) {
                String[] line = br.readLine().split(" ");
                for(int k=0; k<M; k++){
                    int n = Integer.parseInt(line[k]);
                    map[i][j][k] = n;
                    if(n==-1){
                        amount-=1;
                    }
                    if(n==1){
                        qp.add(new int[]{i,j,k});
                    }
                }
            }
        }
        if(qp.size() == amount){
            System.out.println(0);
            return;
        }
        int day = 0;
        int count = qp.size();

        while(!qp.isEmpty()){
            day+=1;
            int size = qp.size();
            for(int i=0; i<size;i++){
                int[] poll = qp.poll();
                int h = poll[0];
                int r = poll[1];
                int c = poll[2];
                for(int j=0; j<6; j++){
                    if(h+z[j]>=0 && h+z[j]<H && r+x[j]>=0 && r+x[j]<N && c+y[j]>=0 && c+y[j]<M){
                        if(map[h + z[j]][r + x[j]][c + y[j]] == 0){
                            count+=1;
                            map[h + z[j]][r + x[j]][c + y[j]] = 1;
                            qp.add(new int[]{h+z[j], r+x[j], c+y[j]});
                        }
                    }
                }
            }
            if(count == amount){
                System.out.println(day);
                return;
            }
        }
        System.out.println(-1);

    }
}
