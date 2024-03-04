
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

	public static void main(String []agrs) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] list= br.readLine().split(" ");

		int x=Integer.parseInt(list[0]);
		int y=Integer.parseInt(list[1]);
		int w=Integer.parseInt(list[2]);
		int h=Integer.parseInt(list[3]);

		int min=0;
		if(x<=w&&0<=x) {
			if(y<=h&&0<=y) {
				int min1=Math.min(Math.abs(w-x), Math.abs(h-y));
				int min2 = Math.min(Math.abs(x-0), Math.abs(y-0));
				min= Math.min(min1, min2);
			}
			else {
				min= Math.abs(h-y);
			}

		}
		else {
			if(y<=h&&0<=y) {
				min =  Math.abs(w-x);
			}
			else {
				min= Math.abs(h-y)+Math.abs(w-x);
			}
		}

		System.out.println(min);
	}


}