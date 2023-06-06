package ktds.june.week1;

import java.util.*;

/**
 * 6월 1주차
 *  42578번: 의상
 *  해시
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Solution3 {

  public static void main(String[] args) {
    String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    int answer = 1;

    // 의상 종류별 개수 => HashMap에 저장
    HashMap<String, Integer> types = new HashMap<>();
    for (int i=0; i<clothes.length; i++) {
      String type = clothes[i][1];
      int cnt = (types.get(type) != null) ? types.get(type) : 0;
      types.put(type, cnt+1);
    }

    /**
     * 의상을 입는 모든 경우의 수 = 의상의 종류마다 내가 선택할 수 있는 경우의 수 * 의상 종류의 개수 곱하기
     * - 의상의 종류마다 내가 선택할 수 있는 경우의 수 = (종류별로 존재하는 서로 다른 의상 개수) + 1
     * (+1을 하는 이유 : 해당 종류의 의상을 입지 않아도 되기 때문에 해당 종류의 의상을 고르지 않는 경우까지 포함)
     * - 아무 의상도 입지 않는 경우도 포함되어있기 때문에 최종 답에서 제외 필요
     */
    for (Map.Entry<String, Integer> entry : types.entrySet()) {
      answer *= entry.getValue() + 1;
    }

    System.out.println(answer-1);
  }

}
