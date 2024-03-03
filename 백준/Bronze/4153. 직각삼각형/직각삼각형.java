
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

	public static void main(String []agrs) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		

		while(true) {
			String[] list= br.readLine().split(" ");
			if(list[0].equals("0")&&list[1].equals("0")&&list[2].equals("0")) {
				break;
			}
			int[] triangle_list=new int[3];
			for(int i=0; i<3; i++) {
				triangle_list[i]= Integer.parseInt(list[i]);
			}
			
			Arrays.sort(triangle_list);
			
			if(Math.pow(triangle_list[0],2)+Math.pow(triangle_list[1],2)==Math.pow(triangle_list[2],2)) {
				
					sb.append("right\n");
			}
			else{
					sb.append("wrong\n");
			}
			
			
			
		}

		System.out.println(sb.toString());
	}


}