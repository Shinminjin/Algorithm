import java.util.*;
import java.lang.*;

/**
 * 프로그래머스 42579 베스트앨범
 * 
 * 해시,
 * 
 * 재생횟수와 고유번호를 PriorityQueue로 정의
 */

class Solution {
    static class Song implements Comparable<Song> {
        int plays;
        int originIndex;
        
        Song(int plays, int originIndex) {
            this.plays = plays;
            this.originIndex = originIndex;
        }
        
        // 우선순위 설정: 1. 재생횟수, 2. 고유 번호
        @Override
        public int compareTo(Song s) {
            return this.plays == s.plays ? (this.originIndex - s.originIndex) : s.plays - this.plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlays = new HashMap<>();
        Map<String, PriorityQueue<Song>> songsOrder = new HashMap<>();

        int size = genres.length;
        
        // 장르 별 재생 횟수 집계
        for(int i = 0; i < size; i++) {
            String curr = genres[i];
            if(genrePlays.get(curr) == null)
                genrePlays.put(curr, plays[i]);
            else
                genrePlays.put(curr, genrePlays.get(curr) + plays[i]);
            
            // 노래 별 순서대로 저장
            if(songsOrder.get(curr) == null)
                songsOrder.put(curr, new PriorityQueue<Song>());
            songsOrder.get(curr).offer(new Song(plays[i], i));
        }
        
        int arrSize = genrePlays.size();
        
        // 장르 별 줄세우기
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(genrePlays.entrySet());
        entryList.sort((a, b)->{
            return b.getValue() - a.getValue();
        });
        
        List<Integer> answerList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList) {
            answerList.add(songsOrder.get(entry.getKey()).poll().originIndex);
            if(!songsOrder.get(entry.getKey()).isEmpty())
                answerList.add(songsOrder.get(entry.getKey()).poll().originIndex);
        }
        
        int[] answer = new int[answerList.size()];
        size = answerList.size();
        for(int i = 0; i < size; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}