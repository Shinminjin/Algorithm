package ktds.may.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 5월 1주차_자료구조2
 * 14425번: 문자열 집합
 * 집합
 * https://www.acmicpc.net/problem/14425
 */
public class Solution1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int result = 0;
    // 1. N, M 입력
    String[] num = br.readLine().split(" ");
    int n = Integer.parseInt(num[0]);
    int m = Integer.parseInt(num[1]);
    // 2. 집함 S (중복안되니까 배열말고 집합으로 해도 됨... 아마 자료구조 문제인 거 보면 HashMap을 사용하는 게 출제의도에 맞지 않을까..하는...)
    String[] s = new String[n];
    for (int i = 0; i < n; i++) {
      s[i] = br.readLine();
    }
    // 3. 검사해야하는 문자열
    for (int i = 0 ; i < m ; i++) {
      String target = br.readLine();
      for (int j = 0 ; j < n ; j++) {
        if (target.equals(s[j])) {
          result++;
          break;
        }
      }
    }
    System.out.println(result);
    br.close();
  }
}
