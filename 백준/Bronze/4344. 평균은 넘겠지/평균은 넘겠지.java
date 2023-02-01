import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=0; i< tc; i++){
            String [] line = br.readLine().split(" ");
            double sum=0;
            for(int j=1; j<line.length; j++){
                sum+= Integer.parseInt(line[j]);
            }
            double aver= sum / (line.length-1);
            double count =0;
            for(int j=1; j<line.length; j++){
                if(Integer.parseInt(line[j])>aver){
                    count+=1;
                }}
            sb.append(String.format("%.3f",count*100/(line.length-1))).append("%").append("\n");
        }
        System.out.println(sb);

    }}