import java.io.*;

public class Main{
    static int N;
    static boolean [] checked;
    static String sleepers;
    static String[] startPeople;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);
        int M = Integer.parseInt(input[3]);

        checked = new boolean[N+3];
        // List<Integer> sleeper = new ArrayList<>();
        sleepers = " "+ br.readLine();
        sleepers += " ";
        startPeople = br.readLine().split(" ");
        for(int i = 0; i < startPeople.length; i++){
            int idx = Integer.parseInt(startPeople[i]);
            dfs(idx);
        }
        for(int i=0; i<M; i++){
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);

            int count =0;
            for(int j= start; j<=end; j++){
                if(!checked[j]){
                    count +=1;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int idx){

        if(sleepers.contains(" "+idx+" ")){
            return;
        }
        int n = idx;

        while(idx<N+3){
            if(sleepers.contains(" "+idx+" ")){
                idx += n;
                continue;
            }
            checked[idx] = true;
          //  System.out.println(" " + "idx : "+idx);
            idx += n;
            if(idx<N+3 && !checked[idx] && !sleepers.contains(" "+idx+" ")){
                dfs(idx);
            }


        }

    }
}