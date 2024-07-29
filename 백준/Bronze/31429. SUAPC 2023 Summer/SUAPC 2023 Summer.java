import java.util.*;
import java.io.*;

public class Main{
    
    static final int[][] university = {
        {12,1600},{11,894}, {11,1327}, {10,1311}, {9,1004}, {9,1178}, {9,1357}, {8,837}, {7,1055}, {6,556}, {6,773}
    };
    static int N;
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.print(university[N-1][0] + " "+university[N-1][1]);
	}	

}
