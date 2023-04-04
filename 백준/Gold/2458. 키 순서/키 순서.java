import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] visited;
    static List<Integer>[] bigger;
    static List<Integer>[] smaller;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        bigger = new ArrayList[N];
        smaller = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            bigger[i] = new ArrayList<>();
            smaller[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            bigger[a-1].add(b-1);
            smaller[b-1].add(a-1);
        }


        int count = 0;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            int result = smallerDfs(i) + biggerDfs(i);
            if(result == N-1){
                count +=1;
            }
        }
        System.out.println(count);

    }
    private static int biggerDfs(int idx){
        int count = 0;
        for (int i = 0; i < bigger[idx].size(); i++) {
            if(!visited[bigger[idx].get(i)]){
                count += 1;
                visited[bigger[idx].get(i)] = true;
                count += biggerDfs(bigger[idx].get(i));
            }
        }
        return count;
    }

    private static int smallerDfs(int idx){
        int count = 0;
        for (int i = 0; i < smaller[idx].size(); i++) {
            if(!visited[smaller[idx].get(i)]){
                count += 1;
                visited[smaller[idx].get(i)] = true;
                count += smallerDfs(smaller[idx].get(i));
            }
        }
        return count;
    }


}
