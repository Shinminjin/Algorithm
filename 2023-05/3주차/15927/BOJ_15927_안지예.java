package ktds.may.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 5월 3주차_문자열
 * 15927번: 회문은 회문아니야!!
 * 문자열 - 팰린드롬
 * https://www.acmicpc.net/problem/15927
 */
public class Solution2 {
  public static void main(String[] args) throws IOException {
    /**
     * 팰린드롬이 아닌 가장 긴 부분문자열의 길이
     * 1) 모두 같은 문자열인 경우 (ex. zzz) : -1
     * 2) 팰린드롬인 경우 (ex. ABCBA) : 문자열 길이 - 1 (=> 팰린드롬인 문자열은 맨 앞이나 맨 뒤 문자 하나만 제거해도 팰린드롬 아님)
     * 3) 팰린드롬이 아닌 경우 : 문자열 길이
     */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 문자열 입력
    String word = br.readLine();
    char start = word.charAt(0);
    int len = word.length();

    if (countChar(word, start) == len) {
      // 모두 같은 문자열인 경우
      System.out.println(-1);
    } else {
      int i = 0;
      for ( ; i < len/2 ; i++) {
        if (word.charAt(i) != word.charAt(len-1-i))
          break;
      }

      // 팰린드롬인 경우: 문자열 길이-1, 팰린드롬이 아닌 경우: 문자열 길이
      int result = (i == len/2) ? len -1 : len;

      System.out.println(result);
    }
  }

  public static int countChar(String str, char target) {
    return str.length() - str.replace(String.valueOf(target), "").length();
  }
}
