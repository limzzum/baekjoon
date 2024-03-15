import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main
{
    static class Folder {
        String name;
        List<String> folders;
        List<String> files;
        int totalCnt;
        
        public Folder(String name){
            this.folders = new ArrayList<>();
            this.files = new ArrayList<>();
            this.name = name;
            this.totalCnt = 0;
        }
        
        public void addFolder(String folder){
            folders.add(folder);
        }
        public void addFile(String file){
            files.add(file);
        }
        
    }
    static int N, M, Q;
    static List<Folder> folders = new ArrayList<>();
    static Map<String, Integer> folderIdxMap = new HashMap<>();
    static Map<String, Integer> folderSumType = new HashMap<>();
    static Map<String, Set<String>> dpMap = new HashMap<>();
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    for(int i=0; i<N+M; i++){
	        st = new StringTokenizer(br.readLine());
	        String parent = st.nextToken();
	        String child = st.nextToken();
	        int n = Integer.parseInt(st.nextToken());
	        
	        if(!folderIdxMap.containsKey(parent)){
	            folders.add(new Folder(parent));
	            folderIdxMap.put(parent, folders.size() -1);
	        }
	        
	        if(!folderIdxMap.containsKey(child)){
	            folders.add(new Folder(child));
	            folderIdxMap.put(child, folders.size() -1);
	        }
	        Folder folder = folders.get(folderIdxMap.get(parent));
	        if(n == 1){
	            folder.addFolder(child);
	        }else{
	            folder.addFile(child);
	        }
	    }
	    
	    Q = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<Q; i++){
	        st = new StringTokenizer(br.readLine(), "/");
	        String name = "";
	        while(st.hasMoreTokens()){
	            name = st.nextToken();
	        }
	        if(dpMap.containsKey(name)){
	            sb.append(dpMap.get(name).size()).append(" ");
	            sb.append(folders.get(folderIdxMap.get(name)).totalCnt).append("\n");
	        }else{
	            int totalCnt = dfs(name);
	            sb.append(dpMap.get(name).size()).append(" ");
	            sb.append(totalCnt).append("\n");
	        }
	    }
	    System.out.println(sb);
	}	
	
	private static int dfs(String name){
	    
	    Folder folder = folders.get(folderIdxMap.get(name));
	    if(dpMap.containsKey(name)){
	        return folder.totalCnt;
	    }
	    
	    dpMap.put(name, new HashSet<>());
	    int sum = 0;
	    for(int i=0; i<folder.folders.size(); i++){
	        sum += dfs(folder.folders.get(i));
	        dpMap.get(name).addAll(dpMap.get(folder.folders.get(i)));
	    }
	    
	    for(int i = 0; i<folder.files.size(); i++){
	        sum += 1;
	        dpMap.get(name).add(folder.files.get(i));
	    }
	    return folder.totalCnt = sum;
	}
}
