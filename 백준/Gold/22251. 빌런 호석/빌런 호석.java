import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static int N, K, P, X;
	static boolean[][] isOn = new boolean[10][7];
	static String[] numberFormat;
	static int answer;
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        numberFormat = new String[7];
	    
	    init();
	    for(int i=1; i<= N; i++){
	        if(X != i && canChage(X, i)){
	            answer += 1;
	        }
	    }
	    System.out.print(answer);
	    
	}
	
	private static boolean canChage(int from, int to){
	    String t = String.valueOf(to);
	    int len = Math.max(String.valueOf(from).length(), t.length());
	    t = format(t, len);

	    int cnt = 0;
	    for(int i=0; i<len; i++){
	        for(int j=0; j<7; j++){
	            if(isOn[numberFormat[len].charAt(i)-'0'][j] != isOn[t.charAt(i) - '0'][j]){
	                cnt += 1;
	                if(cnt > P){
	                    return false;
	                }
	            }
	        }
	    }
	    return true;
	}
	
	private static String format(String word, int len){
	    if(word.length() >= len){
	        return word;
	    }
	    String formatWord = "";
	    for(int i=0; i<len-word.length(); i++){
	        formatWord += "0";
	    }
	    return formatWord += word;
	}

    private static void init(){
        for(int i=1; i<=6; i++){
            numberFormat[i] = format(String.valueOf(X), i);
        }
        
        isOn[0] = new boolean[]{true, true, true, false, true, true, true};
        isOn[1] = new boolean[]{false, false, true, false, false, false, true};
        isOn[2] = new boolean[]{false, true, true, true, true, true, false};
        isOn[3] = new boolean[]{false, true, true, true, false, true, true};
        isOn[4] = new boolean[]{true, false, true, true, false, false, true};
        isOn[5] = new boolean[]{true, true, false, true, false, true, true};
        isOn[6] = new boolean[]{true, true, false, true, true, true, true};
        isOn[7] = new boolean[]{false, true, true, false, false, false, true};
        isOn[8] = new boolean[]{true, true, true, true, true, true, true};
        isOn[9] = new boolean[]{true, true, true, true, false, true, true};
    }
}
