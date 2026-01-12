import java.util.*;
import java.io.*;

public class Main{
    
    private static int N;
    private static List<Integer> heights = new ArrayList<>();
    private static int[] count;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++){
		    heights.add(Integer.parseInt(st.nextToken()));
		}
		
		double maxH;
		int answer = 0;
		double incli;
		for(int i=0; i<N; i++){
		    maxH = Integer.MIN_VALUE;
		    for(int j=i+1; j<N; j++){
		        incli = ((double) (heights.get(j) - heights.get(i))) / (j - i);
		        if(incli > maxH){
		            count[i] += 1;
		            count[j] += 1;
		            maxH = incli;
		        }
		    }
		    answer = Math.max(answer, count[i]);
		}
		
		System.out.print(answer);
	}
}
