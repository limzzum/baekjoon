import java.util.*;
import java.io.*;

public class Main{

    static int N, M;
    static char[] words;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = br.readLine().toCharArray();
        M = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            sb.append(getCnt(start, end)).append("\n");
        }
        
        System.out.print(sb);
    }
    
    private static int getCnt(int start, int end){
        int left;
        int right;
        int cnt;
        int answer = 0;
        for(int i=start; i<end; i++){
            cnt = 0;
            left = i;
            right = i+1;
            while(left >= start && right <= end){
                if(words[left] == words[right]){
                    cnt += 1;
                }
                left -=1;
                right += 1;
            }
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}
