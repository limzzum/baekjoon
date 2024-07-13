import java.util.*;
import java.io.*;

class Main{
   
    static int N;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparing(a -> -a));
        int answer = 0;
        for(int k=0; k<N; k++){
            st = new StringTokenizer(br.readLine());
            int score = 0;
            for(int i=0; i<2; i++){
                score = Math.max(Integer.parseInt(st.nextToken()), score);
            }
            for(int i=0; i<5; i++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
            for(int i=0; i<2; i++){
                score += pq.poll();
            }
            answer = Math.max(answer, score);
            pq.clear();
            
        }
        
        System.out.print(answer);
    }

    
}