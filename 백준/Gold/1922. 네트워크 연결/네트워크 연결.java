import java.io.*;
import java.util.*;

public class Main{
	
	static int N,M;
	static int [] parent;
	static ArrayList<Node> list;
	
	
	static class Node{
		
		int a;
		int b;
		int cost;
		
		public Node(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		
		parent= new int[N+1];
		
		int a,b,c;
		int min=10000;
		list= new ArrayList<Node>();
//		for(int i=0; i<N+1; i++) {
//			list[i]= new ArrayList();
//		}
//		
		for(int i=0; i<M; i++) {
			st =new StringTokenizer(br.readLine());
			a= Integer.parseInt(st.nextToken());
			b= Integer.parseInt(st.nextToken());
			c= Integer.parseInt(st.nextToken());
			
			list.add(new Node(a,b,c));
				
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				return a.cost-b.cost;
			}
		});
		
		
		for(int i=1; i<N+1; i++) {
			parent[i]=i;
		}
	    
		int sum=0;
		int count=0;
		for(int i=0; i<M; i++) {
			int from= list.get(i).a;
			int to= list.get(i).b;
			if(find(from)==find(to)) {
				continue;
			}
			else {
				sum+=list.get(i).cost;
				union(from,to);
				count++;
			}
			if(count==N-1) {
				break;
			}
		}
		
		System.out.println(sum);
		
		
		
		
	}
	
	static void union(int a, int b) {
        a= find(a);
        b= find(b);
		parent[a]=b;
	
	}
	static int find(int target) {
		if(parent[target]==target) {
			return target;
		}
		else {
			return parent[target]=find(parent[target]);
		}
		
	}
}