import java.io.*;
import java.util.*;

public class Main{

    static class Person implements Comparable<Person>{
        int age;
        String name;
        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
        @Override
        public String toString(){
            return age+" "+name;
        }
    }
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Person> persons = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String [] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            persons.add(new Person(age, name));
        }
        Collections.sort(persons);
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}