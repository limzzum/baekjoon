import java.io.*;

public class Main{

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int right = N/M*10000;
        int left = 1;

        String[] line = br.readLine().split(" ");

        int mid = 0;
        int answer =  right;
        while (left<=right){
                mid = (left+right)/2;
                long sum = 0;
                int cnt = 1;
                for(int i=0; i<line.length; i++){
                    int num = Integer.parseInt(line[i]);
                    if(num>mid){
                        cnt = M+1;
                        break;
                    }
                    sum += num;
                    if(sum>mid){
                        sum = num;
                        cnt +=1;
                    }
                    if(cnt>M){
                        break;
                    }
                }
                if(cnt>M){
                    left = mid+1;
                }
                else{
                    answer = Math.min(answer,mid);
                    right = mid -1;
                }
        }
        System.out.println(answer);
    }

}