import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken()) -1;
            String word = st.nextToken();
            System.out.println(word.substring(0,len)+word.substring(len+1));
}
    }
}