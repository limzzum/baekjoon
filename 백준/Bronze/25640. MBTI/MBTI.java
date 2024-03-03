import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mbti = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String friend = br.readLine();
            if(mbti.equals(friend)){
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}