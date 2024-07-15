import java.util.*;
import java.io.*;

class Main{
   
    static int N;
    static List<Integer> scores = new ArrayList<>();
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int num = (int) Math.round((double)N /100 *15);
        
        for(int i=0; i<N; i++){
            scores.add(Integer.parseInt(br.readLine()));
        }
        
        scores.sort(Comparator.comparing(a -> a));
        double sum = 0;
        for(int i=num; i<scores.size()- num; i++){
            sum += scores.get(i);
        }
        
        System.out.print(Math.round(sum/(N-num*2)));

    }  
}