import java.util.*;

class Solution {
    
    static Map<String, Integer> termsInfo = new HashMap<>();
    static int todayValue;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        todayValue = getDateValue(today);
        
        StringTokenizer st;
        for(String term : terms){
            st = new StringTokenizer(term);
            termsInfo.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        String date;
        String term;
        List<Integer> answerIndexs = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            st = new StringTokenizer(privacies[i]);
            date = st.nextToken();
            term = st.nextToken();
            if(isOverDate(date, term)){
                answerIndexs.add(i+1);
            }
        }
        return answerIndexs.stream().mapToInt(x-> x).toArray();
    }
    
    private int getDateValue(String date){
        String[] ymdDate = date.split("\\.");
        int value = Integer.parseInt(ymdDate[2]);
        value += 28 * Integer.parseInt(ymdDate[1]);
        value += 28 * 12 * Integer.parseInt(ymdDate[0]);
        return value;
    }
    
    private boolean isOverDate(String date, String term){
        return todayValue >= getDateValue(date) + termsInfo.get(term) * 28;
    }
}