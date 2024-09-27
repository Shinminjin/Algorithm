package ktds.may.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 5월 3주차_문자열
 * 13022번: 늑대와 올바른 단어
 * 문자열
 * https://www.acmicpc.net/problem/13022
 */
public class Solution1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 단어 입력
    String word = br.readLine();
    // 각 문자 개수 count (w, o, l, f)
    int count[] = {0, 0, 0, 0};
    // wolf 순서 => 정규식
    String reg = "(w+o+l+f+)+";
    // 개수 check
    int checkCnt = 0;
    // 출력값 (올바른 단어: 1 / 아니면 0)
    int result = 1;

    for (int i = 0 ; i < word.length() ; i++) {
      char c = word.charAt(i);
      // w로 시작하지 않는 경우
      if (i == 0 && c != 'w') {
        result = 0;
        break;
      }
      // count
      switch (c) {
        case 'w': count[0]++;
          break;
        case 'o': count[1]++;
          break;
        case 'l': count[2]++;
          break;
        case 'f': count[3]++;
          break;
      }

      // f인 경우 각 문자 개수가 모두 같아야 함
      // 이렇게 개수 세는 거 아님...? 왜 계속 count 0으로 되는거임...?ㅠㅠ
//      checkCnt = Collections.frequency(Arrays.asList(count), count[0]);

      checkCnt = check(count, count[0]);

      // "wwoollff"인 경우 'f'일 때 다음 문자가 'w'일 때만 check 해야 함
      if (i < word.length()-1 && c == 'f' && checkCnt != 4 && word.charAt(i+1) == 'w') {
        result = 0;
        break;
      }
    }

    if (!word.matches(reg) || check(count, count[0]) != 4) {
      result = 0;
    }

    System.out.println(result);

  }

  public static int check(int [] count, int target) {
    int result = 0;
    for (int cnt : count) {
      if (cnt == target) {
        result++;
      }
    }
    return result;
  }
}
