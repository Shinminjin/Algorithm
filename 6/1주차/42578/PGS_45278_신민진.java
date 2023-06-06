import java.util.*;

class Solution {
	public int solution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();

        // 의상 종류별로 구분하여 카운팅
		for (int i = 0 ; i < clothes.length ; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
            else {
                map.put(clothes[i][1], 1);
            }
        }

        // 경우의 수 계산하기
		int answer = 1;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			answer *= entry.getValue() + 1;

		}

        // 입지 않는 경우 제외하기
		return answer - 1;
	}
}