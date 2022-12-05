package gold5.P7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P7576 {
    public static class Node {
        int r;
        int c;
        int day;

        public Node(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> qp = new LinkedList<>();

        String[] input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[][] box = new int[N][M];

        int amount = 0;

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int state = Integer.parseInt(line[j]);
                if (state == 0) {
                    amount += 1;
                }
                if (state == 1) {
                    qp.add(new Node(i, j, 0));
                }
                box[i][j] = state;
            }
        }

        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};

        int answer = 0;
        while (!qp.isEmpty()) {
            Node node = qp.poll();
            for (int j = 0; j < 4; j++) {
                int r = node.r + row[j];
                int c = node.c + col[j];
                if (r >= 0 && r < N && c >= 0 && c < M) {
                    if (box[r][c] == 0) {
                        box[r][c] = 1;
                        qp.add(new Node(r,c,node.day+1));
                        amount-=1;
                    }
                }
            }
           answer = node.day;
        }

        if(amount==0){
            System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }
    }
}
