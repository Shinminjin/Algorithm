package ktds.may.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 5월 4주차
 * 14501번: 퇴사
 * DP, 브루트포스
 * https://www.acmicpc.net/problem/14501
 */
public class Solution2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int [] t = new int[n];
    int [] p = new int[n];
    int [] result = new int[n+1];

    for (int i=0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      t[i] = Integer.parseInt(st.nextToken());
      p[i] = Integer.parseInt(st.nextToken());
    }

    for (int i=0; i<n; i++) {
      // 날짜가 범위를 넘어가지 않는 경우
      if (i + t[i] <= n) {
        // 현재 날짜에서 소요 시간과 비용을 더하여 저장
        // 이후, 중복될 때 최대값을 넣음
        result[i + t[i]] = Math.max(result[i + t[i]], result[i] + p[i]);
      }
      // 해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어주어야 함
      result[i+1] = Math.max(result[i+1], result[i]);
    }

    System.out.println(result[n]);

  }
}
