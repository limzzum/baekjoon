import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] trees;
    static int two;
    static int one;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        trees = new int[N];

        boolean isThree = true;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(trees[i] == 0){
                continue;
            }
            two += trees[i] /2;
            one += trees[i] % 2;

            if(trees[i] % 3 != 0){
                isThree = false;
            }
        }

        if(isThree){
            System.out.println("YES");
            return;
        }
        if(two < one){
            System.out.println("NO");
            return;
        }

        if(two == one || (two - one) % 3 == 0 ){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");


    }

}
