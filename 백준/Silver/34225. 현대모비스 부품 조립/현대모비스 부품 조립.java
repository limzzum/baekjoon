import java.util.*;
import java.io.*;

public class Main {
    
    static class Module{
        int score;
        int index;
        public Module(int score, int index){
            this.score = score;
            this.index = index;
        }
    }
    
    static int N;
    static List<Module> modules = new ArrayList<>();
    static Map<Integer, Integer> scoreCnt = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++){
		    int score = Integer.parseInt(st.nextToken());
		    modules.add(new Module(score, i+1));
		    scoreCnt.put(score, scoreCnt.getOrDefault(score, 0) + 1);
		}
		modules.sort(Comparator.comparing((Module a) -> a.score));
		int min = modules.get(0).score;
		
		long sum = min * scoreCnt.get(min);;
		int pre = min;
		for(int i=1; i < N; i++){
		    if(modules.get(i).score == pre){
		        continue;
		    }
		    
	        pre = modules.get(i).score;
		    if(sum < modules.get(i).score - min){
		        min = modules.get(i).score;
		        sum = (long) modules.get(i).score * scoreCnt.get(modules.get(i).score);
		        continue;
		    }
		    sum += (long) modules.get(i).score * scoreCnt.get(modules.get(i).score);
		}
		
		StringBuilder sb = new StringBuilder();
		int ansCnt = 0;
		for(int i=0; i<N; i++){
		    if(modules.get(i).score >= min){
		        ansCnt += 1;
		        sb.append(modules.get(i).index).append(" ");  
		    }
		}
		System.out.println(ansCnt);
		System.out.print(sb);
	}
}
