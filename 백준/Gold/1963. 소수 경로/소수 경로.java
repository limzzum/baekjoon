import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] prime = new int[10000];
    static int[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        initPrime();
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            visited = new int[10000];
            answer = Integer.MAX_VALUE;
            Arrays.fill(visited, Integer.MAX_VALUE);
            visited[A] = 0;
            dfs(A, B, 0);
            if (answer == Integer.MAX_VALUE) {
                sb.append("Impossible");
            } else {
                sb.append(answer);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void initPrime() {
        for (int j = 2; j < 10000; j++) {
            if (prime[j] == 0) {
                for (int k = j * 2; k < 10000; k += j) {
                    prime[k] = 1;
                }
            }
        }
    }

    private static void dfs(int curNum, int target, int count) {
        if (curNum == target) {
            answer = Math.min(answer, count);
            return;
        }
        if (count > answer) {
            return;
        }
        int v1000 = (curNum / 1000) * 1000;
        int v100 = (curNum / 100) * 100;
        int v10 = (curNum / 10) * 10;

        for (int i = 1000; i < 10000; i += 1000) {
            if (prime[curNum % 1000 + i] == 0 && count<visited[curNum % 1000 + i]) {
                visited[curNum % 1000 + i] = count;
                dfs(curNum % 1000 + i, target, count + 1);
            }
        }
        for (int i = 0; i < 1000; i += 100) {
            int num = v1000 + curNum % 100 + i;
            if (prime[num] == 0 && count < visited[num]) {
                visited[num] = count;
                dfs(num, target, count + 1);
            }
        }

        for (int i = 0; i < 100; i += 10) {
            int num = v100 + curNum % 10 + i;
            if (prime[num] == 0 && count<visited[num]) {
                visited[num] = count;
                dfs(num, target, count + 1);
            }
        }
        for (int i = 0; i < 10; i += 1) {
            int num = v10 + i;
            if (prime[num] == 0 && count<visited[num]) {
                visited[num] = count;
                dfs(num, target, count + 1);
            }
        }


    }
}
