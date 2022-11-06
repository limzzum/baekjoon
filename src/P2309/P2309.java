package P2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2309 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Integer> heightList = new ArrayList<>();
    static boolean[] shortPeople;
    static List<Integer> answer = new ArrayList<>();
    static int sum=0;

    static public void main(String[] args) throws Exception{
        inputRead();
        selectNoneShortPeople();
        getAnswer();

        System.out.println(sb.toString());

    }

    private static void getAnswer() {
        for(int i=0; i<9; i++){
            if(!shortPeople[i]){
                answer.add(heightList.get(i));
            }
        }
        Collections.sort(answer);
        for (int i=0; i<7; i++){
            sb.append(answer.get(i)).append("\n");
        }
    }

    private static boolean IsSum100() {
        sum=0;
        for(int i=0; i<9; i++){
            if(!shortPeople[i]){
                sum+= heightList.get(i);
            }
        }
        return sum == 100;
    }

    private static void selectNoneShortPeople() {
        for(int i=0; i<heightList.size(); i++){
            for(int j=i+1; j<heightList.size(); j++){
                shortPeople = new boolean[9];
                shortPeople[i]=true;
                shortPeople[j]=true;
                if(IsSum100()){
                    return;
                }
            }
        }
    }

    static public void inputRead() throws IOException {
        for(int i=0; i<9; i++){
            int height = Integer.parseInt(br.readLine());
            heightList.add(height);
        }
    }
}
