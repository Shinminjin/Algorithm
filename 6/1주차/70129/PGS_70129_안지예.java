package ktds.june.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6월 1주차
 * 70129번: 월간 코드 챌린지 시즌1 > 이진 변환 반복하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class Solution2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int [] answer = {0, 0};

    while (!"1".equals(s)) {
      answer[1] += countZero(s);
      s = binaryTransition(s.replace(String.valueOf('0'), ""));
      answer[0]++;
    }

    System.out.println(Arrays.toString(answer));
  }

  // 0 개수
  public static int countZero(String str) {
    return str.length() - str.replace(String.valueOf('0'), "").length();
  }

  // 이진변환
  public static String binaryTransition(String str) {
    return Integer.toBinaryString(str.length());
  }

}
