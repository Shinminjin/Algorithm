package ktds.may.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 5월 4주차
 * 15624번: 피보나치 수 7
 * DP
 * https://www.acmicpc.net/problem/15624
 */
public class Solution1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int NUM = 1000000007;

    int n = Integer.parseInt(br.readLine());
    int [] fibonacci = new int[n+1];

    for (int i = 0; i<=n; i++) {
      if (i == 0 || i == 1) {
        fibonacci[i] = i;
      } else {
        fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % NUM;
      }
    }

    System.out.println(fibonacci[n]);

  }
}
