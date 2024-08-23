import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, K;
    static char[][] shapes;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        shapes = new char[N][N];

        for(int i=0; i<N; i++){
            shapes[i] = br.readLine().toCharArray();
        }
        K = Integer.parseInt(br.readLine());
        printMirror();
    }

    private static void printMirror(){
        if(K == 1){
            defaultMirror();
        }else if(K == 2){
            leftRightMirror();
        }else {
            upDownMirror();
        }
        System.out.println(sb);
    }

    private static void defaultMirror(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(shapes[i][j]);
            }
            sb.append("\n");
        }
    }

    private static void leftRightMirror(){
        for(int i=0; i<N; i++){
            for(int j=N-1; j>=0; j--){
                sb.append(shapes[i][j]);
            }
            sb.append("\n");
        }
    }

    private static void upDownMirror(){
        for(int i=N-1; i>=0; i--){
            for(int j=0; j<N; j++){
                sb.append(shapes[i][j]);
            }
            sb.append("\n");
        }
    }

}
