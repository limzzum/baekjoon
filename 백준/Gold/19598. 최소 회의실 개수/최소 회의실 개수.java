import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int totalRoomCnt=0;
    static int emptyRoomCnt=0;

    static enum Type{START, END}
    static class Meeting{
        Type type;
        int time;
        public Meeting(Type type, int time){
             this.type = type;
             this.time = time;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Meeting> pq = new PriorityQueue<>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return Integer.compare(o1.time, o2.time);
            }
        });
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Meeting(Type.START, start));
            pq.add(new Meeting(Type.END, end));
        }

        while (!pq.isEmpty()){
            Meeting poll = pq.poll();
            if(poll.type == Type.START){
                if(emptyRoomCnt == 0){
                    totalRoomCnt += 1;
                }else {
                    emptyRoomCnt -= 1;
                }
            }else {
                emptyRoomCnt += 1;
            }
        }
        System.out.println(totalRoomCnt);

        
    }
}
