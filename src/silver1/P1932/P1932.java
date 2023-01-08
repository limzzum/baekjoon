package silver1.P1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1932 {
    static int [][] tree;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new int[N][N];
        for (int i=0; i<N; i++){
            String[] line = br.readLine().split(" ");
            int idx = 0;
            for (String s : line) {
                tree[i][idx] = Integer.parseInt(s);
                idx +=1;
            }
        }

        for (int i=1; i<N; i++){
            for (int j=0; j<=i; j++){
                int plus = tree[i-1][j];
                if(j-1>=0){
                    plus = Math.max(plus, tree[i-1][j-1]);
                }
                tree[i][j] += plus;
            }
        }
        int max = 0;
        for(int a : tree[N-1]){
            if(a>max){
                max = a;
            }
        }
        System.out.println(max);
    }

}
