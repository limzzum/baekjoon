
import java.io.*;
import java.util.*;

public class Main{
	
	static int N,M;
	static int[] inList;
//	static ArrayList<Integer>[] outList;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		inList= new int[N+1];
		ArrayList<Integer>[] outList= new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			outList[i]= new ArrayList();
			
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			//outList[a]= b; 
			inList[b]+=1;
			outList[a].add(b);	
			}
		
		Queue<Integer> qp=new LinkedList();
		for(int i=1; i<N+1; i++) {
			if(inList[i]==0) {
				qp.add(i);
			}
		}
		
		
	
		while(!qp.isEmpty()) {
			
			
		for(int i=1; i<N+1; i++) {
			int index= qp.poll();
			sb.append(index+" ");
			for(int next:outList[index]) {
				inList[next]--;
				if(inList[next]==0) {
					qp.add(next);
				}
			}
			
		}
		
		}
		System.out.println(sb.toString());
	}
}