import java.util.*;

class Solution {
    
    static class User {
        String id;
        Set<String> reportFrom;
        
        User(String id){
            this.id = id;
            this.reportFrom = new HashSet<>();
        }
        
        public void reported(String id){
            reportFrom.add(id);
        }
        
        public void sendMail(int k){
            if(reportFrom.size() >= k){
                for(String from : reportFrom){
                    mailCnt[indexs.get(from)] += 1;
                }
            }
        }
        
    }
    static Map<String, Integer> indexs = new HashMap<>();
    static List<User> users = new ArrayList<>();
    static int[] mailCnt;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        mailCnt = new int[id_list.length];
        
        for(String id : id_list){
            users.add(new User(id));
            indexs.put(id, users.size()-1);
        }
        
        StringTokenizer st;
        String reporter;
        String villain;
        for(String rp : report){
            st = new StringTokenizer(rp);
            reporter = st.nextToken();
            villain = st.nextToken();
            users.get(indexs.get(villain)).reported(reporter);
        }
        
        for(User user : users){
            user.sendMail(k);
        }

        return mailCnt;
    }
}