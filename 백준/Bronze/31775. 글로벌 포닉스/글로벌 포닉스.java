import java.util.*;
import java.io.*;

public class Main{

    static Set<Character> set = new HashSet<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<3; i++){
            set.add(br.readLine().charAt(0));
        }
        
        if(set.contains('k') && set.contains('l') && set.contains('p')){
            System.out.println("GLOBAL");
        }else {
            System.out.println("PONIX");
        }
	}
}
