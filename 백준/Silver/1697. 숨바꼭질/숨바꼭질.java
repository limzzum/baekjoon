import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;

public class Main {
    static int result= 100000;
    static Queue<int[]> qp = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        if(start>end){
            System.out.println(start-end);
            return;
        }
        qp.add(new int[]{start,0});
        bfs(end);
    }

    static boolean [] visited = new boolean[100001];
    private static void bfs( int end) {
       while (!qp.isEmpty()){
           int[] poll = qp.poll();
           if(poll[0]==end){
               System.out.println(poll[1]);
               return;
           }
           for(int i=0; i<3; i++){
               int next=0;
               if(i==0){
                   next = poll[0] +1;
               }
               if(i==1){
                   next = poll[0] -1;
               }
               if(i==2){
                   next = poll[0] *2;
               }

               if(next>=0 && next<=100000 && !visited[next]){
                   qp.add(new int[]{next,poll[1]+1});
                   visited[next]=true;
               }
           }

       }
    }
}
