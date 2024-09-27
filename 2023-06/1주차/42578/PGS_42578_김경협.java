import java.util.*;

/**
 * 프로그래머스 42578 의상
 * 
 * 해시맵 만들어서 종류별 의상 몇 종류
 */

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        int size = clothes.length;
        
        // 의상 종류별 카운트 계산
        for(int i = 0; i < size; i++) {
            String curr = clothes[i][1];
            if(map.get(curr) != null)
                map.put(curr, map.get(curr) + 1);
            else
                map.put(curr, 1);
        }
        
        size = map.size();

        // 의상 종류별 경우의 수 계산
        int answer = 1;
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            answer *=  entry.getValue() + 1;
        }

        // 안 입는 경우 제외
        return answer - 1;
    }
}