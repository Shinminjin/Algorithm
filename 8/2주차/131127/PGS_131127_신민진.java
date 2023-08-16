import java.util.*;

class Solution {
  public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0; // 회원등록 날짜
        
        Map<String, Integer> want_Number_map = new HashMap<>(); // 원하는 제품의 수

        for (int i = 0; i < want.length; i++) {
            want_Number_map.put(want[i], number[i]);
        }

        // 10일 단위로 discount 배열 자르기
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discount_10day = new HashMap<>(); // 10일간의 할인품목

            for (int j = i; j < i + 10; j++) {
                discount_10day.put(discount[j], discount_10day.getOrDefault(discount[j], 0) + 1);
            }

            if (want_Number_map.equals(discount_10day)) answer++;
        }
        
        return answer;
    }
}
