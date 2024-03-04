import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	static String[] words;
	static final int MAN = 1;
	static final int WOMEN = 2;
	static int L;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        L = Integer.parseInt(br.readLine());
        words = br.readLine().split(" ");
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
        	String [] line = br.readLine().split(" ");
        	changeSwitch(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        for(int i=0; i<L; i++) {
        	if(i!=0 && i%20==0) {
        		sb.append("\n");
        	}
        	sb.append(words[i]).append(" ");
        }
        System.out.println(sb);


    }
    private static void changeSwitch(int gender, int number) {
    	if(gender == MAN) {
    		for(int i=1; i<=L; i++) {
    			if((i)%number == 0) {
    				change(i-1);	
    			}
    		}
    	}else {
    		int idx = number -1;
    		change(idx);
    		int left =idx;
    		int right = idx;
    		while(true) {
    			left -=1;
    			right +=1;
        		if(left>=0 && right <L) {
        			if(words[left].equals(words[right])) {
        				change(left);
        				change(right);
        			}else {
        				break;
        			}
        		}else {
        			break;
        		}
    		}		
    	}
    }
 private static void change(int idx) {
	 	int num = Integer.parseInt(words[idx]);
		words[idx] = String.valueOf((num +1) %2);
    }
  
}