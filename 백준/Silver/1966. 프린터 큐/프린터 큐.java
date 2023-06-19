import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
* 포인터가 순환하며 target 보다 중요도가 큰 것들을 모두 처리한 후 다시 순환하면서 target 인덱스까지
* 가는동안 같은 값을 더하고 target 인덱스를 만나면 종료한다.
* */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int [] nums = new int[N];
            List<Integer> values = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
                values.add(nums[j]);
            }

            Collections.sort(values, Collections.reverseOrder());

            boolean [] visited = new boolean[N];
            int order = 1;
            int index = 0;
            while (true){
                if(values.get(0) == nums[index] && !visited[index]){
                    visited[index] = true;
                    if(index == idx){
                        break;
                    }
                    values.remove(0);
                    order += 1;
                }
                index = (index +1) % N;
            }

            sb.append(order).append("\n");

        }
        System.out.println(sb);
    }
}
