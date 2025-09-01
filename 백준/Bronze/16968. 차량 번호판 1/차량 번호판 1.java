import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		
		char pre = 'a';
		int total = 1;
		int num;
		for(int i=0; i<input.length; i++){
		    if(input[i] == 'c'){
		        num = 26;
		    }else {
		        num = 10;
		    }
		    if(pre == input[i]){
		        num -= 1;
		    }
		    total *= num;
		    pre = input[i];
		}
		System.out.print(total);
	}
}
