import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int [] peopleCnt;
    static int[][] connect;
    static boolean [] visited;
    static int answer = 900;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        peopleCnt = new int[N];
        String [] input = br.readLine().split(" ");
        for (int i=0; i<N; i++){
            peopleCnt[i] = Integer.parseInt(input[i]);
        }
        connect = new int[N][];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            String [] line = br.readLine().split(" ");
            int K = Integer.parseInt(line[0]);
            connect[i] = new int[K];
            for (int k = 0; k<K; k++){
                connect[i][k] = Integer.parseInt(line[k+1])-1;
            }

        }

        combine(0,new ArrayList<>());
        if(answer == 900){
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    private static void combine(int startIdx , List<Integer> selected){
        if(selected.size()>0 && selected.size()<N){
            int unSelected = 0;
            for(int i=0; i<N; i++){
                if(!selected.contains(i)){
                    unSelected = i;
                    break;
                }
            }

            int aCnt = 0;
            int bCnt = 0;

            visited = new boolean[N];
            visited[selected.get(0)] =true;
            visited[unSelected] = true;

            if(isconnected(selected.get(0), selected, 1)== selected.size() && isconnected2(unSelected, selected, 1)==N-selected.size()){
                for(int i=0; i<N; i++){
                    if(selected.contains(i)){
                        aCnt += peopleCnt[i];
                    }else{
                        bCnt += peopleCnt[i];
                    }
                }
                answer = Math.min(answer, Math.abs(aCnt-bCnt));

            }

        }
        for(int i=startIdx; i<N; i++){
            selected.add(i);
            combine(i+1, selected);
            selected.remove((Integer)i);
        }
    }

    private static int isconnected(int start, List<Integer> selected, int cnt){
        for(int i=0; i<connect[start].length; i++){
            if(!visited[connect[start][i]] && selected.contains(connect[start][i])){
                visited[connect[start][i]] = true;
                cnt +=  isconnected(connect[start][i], selected, 1);
            }
        }
        return cnt;
    }

    private static int isconnected2(int start, List<Integer> selected, int cnt){
        for(int i=0; i<connect[start].length; i++){
            if(!visited[connect[start][i]] && !selected.contains(connect[start][i])){
                visited[connect[start][i]] = true;
                cnt +=  isconnected2(connect[start][i], selected, 1);
            }
        }
        return cnt;
    }
}
