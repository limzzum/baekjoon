import java.util.*;
import java.io.*;

public class Main{
    
    private static final int[] pieces = {1, 1, 2, 2, 2, 8};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt;
        StringBuilder sb = new StringBuilder();
		for(int i=0; i< pieces.length; i++){
		    cnt = Integer.parseInt(st.nextToken());
		    sb.append(pieces[i] - cnt).append(" ");
		}
		System.out.print(sb);
	}
}
