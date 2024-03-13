import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main
{
    static class Person{
        String name;
        int depth;
        List<Person> childs;
        
        public Person(String name){
            this.name = name;
            this.depth= 0;
            childs = new ArrayList<>();
        }
        
        public String getName(){
            return name;
        }
    }
    
    static int N, M;
    static List<Person> persons = new ArrayList<>();
    static Map<String, Integer> personIdxMap = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    N = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
	    
	    for(int i=0; i< N; i++){
	        String name = st.nextToken();
	        persons.add(new Person(name));
	        personIdxMap.put(name, persons.size() -1);
	    }
	    
	    M = Integer.parseInt(br.readLine());
	    for(int i=0; i<M; i++){
	        st = new StringTokenizer(br.readLine());
	        String child = st.nextToken();
	        String parent = st.nextToken();
	        Person c = persons.get(personIdxMap.get(child));
	        c.depth += 1;
	        persons.get(personIdxMap.get(parent)).childs.add(c);

	    }
	    
	    StringBuilder sb = new StringBuilder();
	    long cnt = persons.stream().filter(o -> o.depth == 0)
	    .count();
		
	    String veryParent = persons.stream().filter(o -> o.depth == 0)
	    .map(e -> e.name)
	    .sorted()
		.collect(Collectors.joining(" "));

	    sb.append(cnt).append("\n").append(veryParent);
	    System.out.println(sb);

	    
	    persons.stream()
	    .sorted(Comparator.comparing(Person::getName))
	    .peek(e -> {
	        e.childs.removeIf(c -> c.depth - e.depth >1);
	        
	    })
	    .map(e -> {
	        return e.name + " "+ e.childs.size() + " "+ e.childs.stream().map(Person::getName)
	        .sorted().collect(Collectors.joining(" "));
	    })
	    .forEach(System.out::println);
	   
	    
	}
	
	
}
