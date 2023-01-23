import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static final String SPLIT_PATTERN = "*+-/";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		List<String> command = new ArrayList<>();
		List<Long> numbers = new ArrayList<>();
		boolean minus = false;
		int idx = 0;
		String n = "";
        
        //입력 값 받기
        //연산자는 command에 저장, 숫자는 numbers에 저장
		for(String li: line.split("")) {
			if(idx==0 && li.equals("-")) {
				minus = true;
				idx+=1;
				continue;
			}
			if(SPLIT_PATTERN.contains(li)) {
				command.add(li);
				if(!n.isEmpty()) {
					numbers.add(Long.parseLong(n));
					n="";
				}
			}else {
				n+= li;
			}
			idx+=1;

		}
		if(!n.isEmpty()) {
			numbers.add(Long.parseLong(n));
			n="";
		}
        //맨 앞 숫자 음수이면 *-1
		if(minus) {
			long removed = numbers.remove(0);
			numbers.add(0, removed*-1);
		}
        
		long answer = 0;
		int start = 0;
		int end = numbers.size()-2;
        
		if(numbers.size() == 1) {
			answer = numbers.get(0);
		}
        
	    // 계산
		for(int i=0; i<command.size(); i++) {
			long resultS = 0;
			long resultE = 0;
			int compare =0;
			if(command.get(start).equals("*")) {
				resultS = numbers.get(start)* numbers.get(start+1);
				compare +=1;
			}
			else if(command.get(start).equals("/")) {
				resultS = numbers.get(start) / numbers.get(start+1);
				compare +=1;
			}
			else if(command.get(start).equals("+")) {
				resultS = numbers.get(start)+ numbers.get(start+1);
			}
			else if(command.get(start).equals("-")) {
				resultS = numbers.get(start)- numbers.get(start+1);
			}
			
			
			if(command.get(end).equals("*")) {
				resultE = numbers.get(end)* numbers.get(end+1);
				compare -=1;
			}
			else if(command.get(end).equals("/")) {
				resultE = numbers.get(end)/ numbers.get(end+1);
				compare -=1;
			}
			else if(command.get(end).equals("+")) {
				resultE =numbers.get(end)+ numbers.get(end+1);
			}
			else if(command.get(end).equals("-")) {
				resultE = numbers.get(end)- numbers.get(end+1);
			}
			
			if(compare>0 || compare==0 && resultS>=resultE) {
				start +=1;
				numbers.set(start, resultS);
				answer = resultS;
			}else {
				numbers.set(end, resultE);
				end-=1;
				answer = resultE;
			}

		}
		
		System.out.println(answer);
		
	}
	
}
