import java.util.*;
import java.io.*;

class Solution {
    static class Music{
        int idx;
        int play;
        public Music(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
    }
    
    static class Musics{
        int playCnt;
        PriorityQueue<Music> musics;
        public Musics(){
            this.musics = new PriorityQueue<>((a, b)-> 
            {
                if(a.play == b.play){
                    return a.idx - b.idx;
                }
                return b.play - a.play;
           });
        }
        
        public void add(Music music){
            musics.add(music);
            playCnt += music.play;
                
        }
        
        public List<Integer> getMusicIndex(){
            List<Integer> result = new ArrayList<>();
            result.add(musics.poll().idx);
            if(!musics.isEmpty()){
                result.add(musics.poll().idx);
            }
            return result;
        }

    }

    static Map<String, Integer> musicIndex = new HashMap<>();
    static List<Musics> allMusic = new ArrayList<>();

    public int[] solution(String[] genres, int[] plays) {
        int N = genres.length;
        for(int i=0; i<N; i++){
            Integer idx = musicIndex.getOrDefault(genres[i], null);

            if(idx != null){
                Musics musics = allMusic.get(idx);
                musics.add(new Music(i, plays[i]));
            }else{
                Musics musics = new Musics();
                musics.add(new Music(i,plays[i]));
                allMusic.add(musics);
                musicIndex.put(genres[i], allMusic.size() -1);
            }
        }
        
        allMusic.sort(Comparator.comparing((a)->a.playCnt));

        
        List<Integer> answers = new ArrayList<>();
        for(int i=allMusic.size() -1; i>=0; i--){
            answers.addAll(allMusic.get(i).getMusicIndex());
        }
        int[] answer = new int[answers.size()];
        
        int idx = 0;
        for(int a: answers){
            answer[idx++] = a;
        }
   
        return answer;
    }
}