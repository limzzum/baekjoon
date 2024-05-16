import java.util.*;
import java.io.*;

public class Main{
    
    static class Baeksoo{
        int specRank;
        int speekRank;
        
        public Baeksoo(int specRank, int speekRank){
            this.specRank = specRank;
            this.speekRank = speekRank;
        }
    }
    
    static int T, N;
    static int highRank;
    static int answer;
    static List<Baeksoo> baeksoos = new ArrayList<>();
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	    T = Integer.parseInt(br.readLine());
	    
	    StringTokenizer st;
	    for(int t=0; t<T; t++){
	        N = Integer.parseInt(br.readLine());
	        baeksoos = new ArrayList<>();
	        answer = 0;
	        highRank = N+1;
	        for(int i=0; i<N; i++){
	            st = new StringTokenizer(br.readLine());
	            baeksoos.add(new Baeksoo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	        }
	        
	        baeksoos.sort(Comparator.comparing(a-> a.specRank));
	    
	        for(Baeksoo baeksoo : baeksoos){
	            if(baeksoo.speekRank < highRank){
	                highRank = baeksoo.speekRank;
	                answer += 1;
	            }
	        }
	        bw.write(answer+"\n");
	    }
	    
	    bw.flush();
	    bw.close();
	}
}
