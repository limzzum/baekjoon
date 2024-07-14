import java.util.*;
import java.io.*;

class Main{
   
    static int N, K;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> words = new ArrayList<>();
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++){
            words.add(br.readLine());
        }
        words.sort(Comparator.comparing(a -> a));
        System.out.print(words.get(K-1));
                
        }
    
}