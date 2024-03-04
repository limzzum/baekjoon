import java.io.*;
import java.util.*;


public class Main{
	
	static int N,M;
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		parent= new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i]=i;
		}
		
		for(int i=0; i<M; i++) {
			st= new StringTokenizer(br.readLine());
			String what=st.nextToken();
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			if(what.equals("0")) {
				int temp= root(a);
				parent[temp]=root(b);
			}
			else if(what.equals("1")) {
				if(root(a)==root(b)) {
					sb.append("YES"+"\n");
				}
				else {
					sb.append("NO"+"\n");
				}
			}
		}
		
		System.out.println(sb);
	}
	
	static int root(int a ) {
		//int root= parent[a];
		if(parent[a]==a) {
			return a;
		}
		else {
			return parent[a]=root(parent[a]);
		}
		
	}
}