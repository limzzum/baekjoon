import java.util.*;
import java.io.*;

public class Main{
    
    static class Student{
        int idx;
        int cost;
        Set<Student> friends;
        
        public Student(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
            friends = new HashSet<>();
        }
        
        public void addFriend(Student student){
            if(student.equals(this)){
                return;
            }
            friends.add(student);
        }
    }
    
    static int N, M, K;
    static boolean[] isFriend;
    static List<Student> students = new ArrayList<>();
    static int answer;
    static int cnt;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isFriend = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            students.add(new Student(i, Integer.parseInt(st.nextToken())));
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            Student studentA = students.get(a);
            Student studentB = students.get(b);
            studentA.addFriend(studentB);
            studentB.addFriend(studentA);
        }
        
        students.sort(Comparator.comparing(a -> a.cost));
        
        for(Student student : students){

            if(isFriend[student.idx]){
                continue;    
            }
            answer += student.cost;
            if(answer > K){
                System.out.print("Oh no");
                return;
            }
            connect(student);
            if(cnt == N){
                System.out.print(answer);
                return;
            }
            
        }
        
	}
	
	private static void connect(Student student){
	    cnt += 1;
	    isFriend[student.idx] = true;
	    for(Student friend : student.friends){
	        if(isFriend[friend.idx]){
	            continue;
	        }
	        connect(friend);
	    }

	}
}
