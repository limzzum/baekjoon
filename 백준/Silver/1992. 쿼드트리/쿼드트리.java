import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	static  StringBuilder sb = new StringBuilder();
	public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int N = Integer.parseInt(br.readLine());
       
        map = new int[N][N];
        
        for(int i=0; i<N; i++) {
        	String[] line = br.readLine().split("");
        	for(int j=0; j<N; j++) {
        		map[i][j] = Integer.parseInt(line[j]);
        	}
        }
        if(N==1) {
        	System.out.println(map[0][0]);
        	return;
        }
        if(isSame(0,0,N)) {
        	System.out.println(map[0][0]);
        	return;
        }
        sb.append("(");
        
        dfs(0,0,N);
        sb.append(")");
        System.out.println(sb);
        
    }
	
	private static void dfs(int r, int c, int size) {
		size /=2;
		if(isSame(r,c,size)) {
			sb.append(map[r][c]);
		}else {
			sb.append("(");
			dfs(r,c,size);
			sb.append(")");
		}
		
		if(isSame(r,c+size,size)) {
			sb.append(map[r][c+size]);
		}else {
			sb.append("(");
			dfs(r,c+size,size);
			sb.append(")");
		}
		
		if(isSame(r+size,c,size)) {
			sb.append(map[r+size][c]);
		}else {
			sb.append("(");
			dfs(r+size,c,size);
			sb.append(")");
		}
		
		if(isSame(r+size,c+size,size)) {
			sb.append(map[r+size][c+size]);
		}else {
			sb.append("(");
			dfs(r+size,c+size,size);
			sb.append(")");
		}
		
		
		
	}
	private static boolean isSame(int r, int c, int size) {
		int num = map[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j = c; j<c+size; j++) {
				if(map[i][j]!= num) {
					return false;
				}
			}
		}
		return true;
	}
 
}
