
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String len= br.readLine();
		int diff=len.length()*9;

		int Num= Integer.parseInt(len);
		int sum;
		char[] charI;
		int i= Num-diff;

		while(true){
			
			if(i==Num) {
				System.out.println(0);
				break;
			}
			
			sum=i;
			
			charI=String.valueOf(i).toCharArray();
			for(int j=0; j<charI.length; j++) {
				sum+=charI[j]-48;
			}
		
			if(sum==Num) {
				System.out.println(i);
				break;
			}
			i++;
		}
		
		
	}
}