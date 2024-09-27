import java.util.*;

/**
 * PGS 할인 행사
 * 
 * 해쉬맵을 통한 빠른 문자열 비교
 */

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        int wantCount = 0;
        
        // 해쉬맵에 원하는제품, 원하는개수 저장
        // 모든 상품을 할인받는지 빠르게 알기 위한 wantCount 합산
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], i);
            wantCount += number[i];
        }
        
        
        int target = 0, answer = 0;
        for(int i = 0, len = discount.length; i < len; i++) {
            // 원하는 제품 체크
            if (wantMap.containsKey(discount[i])) {
                target = wantMap.get(discount[i]);
                number[target]--;
                
                if (number[target] >= 0) {
                    wantCount--;
                }
            }
            
            // 10일 지남 && 지난 제품 체크
            if (i >= 10 && wantMap.containsKey(discount[i - 10])) {
                target = wantMap.get(discount[i - 10]);
                number[target]++;
                
                if (number[target] > 0) {
                    wantCount++;
                }
            }
            
            // 원하는 상품 모두 얻었는지 체크
            if (wantCount == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}