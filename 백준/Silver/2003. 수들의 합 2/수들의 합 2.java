import java.io.*;
import java.util.*;

public class Main{
	
	
	
	public static void main(String[] args) throws FileNotFoundException{
		//System.setIn(new FileInputStream("scr/P1062.java"));	}
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int M= sc.nextInt();
		
		int l=0;
		int h=1;
		
		int answer=0;
		
		int [] list= new int[N];
		for(int i=0; i<N; i++) {
			list[i]=sc.nextInt();
		}
		
		while(true) {
			int sum=0;
			for(int j=l;j<h;j++) {
				sum+=list[j];
			}
			if(sum<M) {
				h++;
			}
			else if(sum>M){
				l++;
			}
			else {
				l++;h++;
				answer++;
			}
			
			if(h==N+1)
				break;
		}
		
		System.out.println(answer);
	
	}
	
}


