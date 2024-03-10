import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos {
        int idx;
        int cnt;
        int nums;

        public Pos(int idx, int cnt, int nums){
            this.idx = idx;
            this.cnt = cnt;
            this.nums = nums;
        }
    }

    static final int[] dx = {-3, +3, -1, +1};
    static int startNum;
    static Map<Integer, Integer> visitMap = new HashMap<>();
    static Queue<Pos> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int startIdx = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 0){
                    startIdx = i*3 + j;
                }
                sb.append(n);
            }
        }

        startNum = Integer.parseInt(sb.toString());
        visitMap.put(startNum, 0);
        queue.add(new Pos(startIdx, 0, startNum));

        while (!queue.isEmpty()){
            Pos pos = queue.poll();
            if(isAnswer(pos.nums)){
                System.out.println(pos.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nIdx = pos.idx + dx[i];

                if(nIdx < 0 || nIdx >= 9){
                    continue;
                }
                if((pos.idx == 2 && nIdx == 3) || (pos.idx == 5 && nIdx == 6)
                || (pos.idx == 3 && nIdx == 2) || (pos.idx == 6 && nIdx == 5)){
                    continue;
                }

                int changedNum = change(pos.nums, pos.idx, nIdx);
                if(!visitMap.containsKey(changedNum)){
                    visitMap.put(changedNum, 0);
                    queue.add(new Pos(nIdx, pos.cnt +1 , changedNum));
                }
            }

        }

        System.out.println(-1);

    }

    private static int change(int num, int aIdx, int bIdx){
        int a = (int) Math.pow(10, 8 - aIdx);
        int b = (int) Math.pow(10, 8 - bIdx);
        int n = (num /b) % 10 ;

        num = num - (n * b);
        num += a * n;
        return num;
    }

    private static boolean isAnswer(int nums) {
        return nums == 123456780;
    }
}

