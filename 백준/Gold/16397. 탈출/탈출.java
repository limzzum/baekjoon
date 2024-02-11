import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {
    static final int MAX_VALUE = 99999;
    static final Pattern pattern = Pattern.compile("([^0])");

    static class Node {
        int cnt;
        int num;
        public Node(int cnt, int num){
            this.cnt = cnt;
            this.num = num;
        }
    }

    static boolean[] isVisited = new boolean[MAX_VALUE + 1];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> queue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        queue.add(new Node(0, N));
        isVisited[N] = true;
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.num == G){
                System.out.println(poll.cnt);
                return;
            }
            if(poll.cnt == T){
                continue;
            }
            int numButtonA = poll.num + 1;
            if(numButtonA <= MAX_VALUE && !isVisited[numButtonA]){
                isVisited[numButtonA] = true;
                queue.add(new Node(poll.cnt + 1, numButtonA));
            }
            if(poll.num * 2 <= MAX_VALUE){
                int numButtonB = getNumButtonB(poll.num);
                if(numButtonB <= MAX_VALUE && !isVisited[numButtonB]){
                    isVisited[numButtonB] = true;
                    queue.add(new Node(poll.cnt +1, numButtonB));
                }
            }

        }

        System.out.println("ANG");

    }

    private static int getNumButtonB(int n){
        String num = String.valueOf(n * 2);
        num = pattern.matcher(num).replaceFirst(m -> String.valueOf(Integer.parseInt(m.group()) -1));

        return Integer.parseInt(num);
    }

}
