import java.util.*;
import java.io.*;

public class Main {
    static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int diff = 0;
		int pre = 0;
		int num = 0;
		for(int i=0; i<N; i++){
		    num = Integer.parseInt(st.nextToken());
		    diff = num - pre;
		    pre = num;
		}
		System.out.print(num + diff);
	}
}
