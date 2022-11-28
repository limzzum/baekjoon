package P26071;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P26071 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> ggoms = new ArrayList<>();
        int [][] edges = new int[4][2];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for (int j=0; j<N; j++){
                if(line.charAt(j)=='G'){

                    ggoms.add(new int[]{i,j});
                }
            }
        }
        if(ggoms.size()==1){
            System.out.println(0);
            return;
        }
        if(isSameRow(ggoms)){
            List<Integer> col = new ArrayList<>();
            for (int[] ggom : ggoms) {
                col.add(ggom[1]);
            }
            Collections.sort(col);
            int answer = Math.min(N-1-col.get(0),col.get(col.size()-1));
            System.out.println(answer);
            return;
        }
        if(isSameCol(ggoms)){
            List<Integer> row = new ArrayList<>();
            for (int[] ggom : ggoms) {
                row.add(ggom[0]);
            }
            Collections.sort(row);
            int answer = Math.min(N-1-row.get(0),row.get(row.size()-1));
            System.out.println(answer);
            return;
        }

        for(int[] ggom:ggoms){
            edges[0][0]= Math.max(edges[0][0],ggom[0]);
            edges[0][1]= Math.max(edges[0][1],ggom[1]);
            edges[1][0]= Math.max(edges[1][0],N-1-ggom[0]);
            edges[1][1]= Math.max(edges[1][1],ggom[1]);
            edges[2][0]= Math.max(edges[2][0],ggom[0]);
            edges[2][1]= Math.max(edges[2][1],N-1-ggom[1]);
            edges[3][0]= Math.max(edges[3][0],N-1-ggom[0]);
            edges[3][1]= Math.max(edges[3][1],N-1-ggom[1]);
        }
        int answer = edges[0][0]+edges[0][1];
        for(int[] edge:edges){
            int temp = edge[0]+edge[1];
            if(temp<answer){
                answer= temp;
            }
        }


        System.out.println(answer);

    }

    private static boolean isSameRow(List<int[]> ggoms) {
        int row = ggoms.get(0)[0];
        for(int[] ggom: ggoms){
            if(ggom[0]!=row){
                return false;
            }
        }
        return true;
    }

    private static boolean isSameCol(List<int[]> ggoms) {
        int col = ggoms.get(0)[1];
        for(int[] ggom: ggoms){
            if(ggom[1]!=col){
                return false;
            }
        }
        return true;
    }
}
