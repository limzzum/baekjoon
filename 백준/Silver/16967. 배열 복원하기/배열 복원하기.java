import java.util.*;
import java.io.*;

public class Main{
    
    static int H, W, X, Y;
    static int[][] sum;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        
        sum = new int[H][W];
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< W; j++){
                sum[i][j] = Integer.parseInt(st.nextToken());
                if(i<X || j<Y){
                    sb.append(sum[i][j]);
                }else {
                    sum[i][j] -= sum[i-X][j-Y];
                    sb.append(sum[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
	    bw.flush();
	    bw.close();
	}
}
