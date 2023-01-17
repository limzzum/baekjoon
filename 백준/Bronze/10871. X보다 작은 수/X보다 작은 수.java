import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int count = Integer.parseInt(st.nextToken());
            arr[i] = count;
            if(arr[i]<max){
                bw.write(String.valueOf(arr[i])+" ");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}