package ktds.may.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 5월 1주차_자료구조2
 * 2075번: N번째 큰 수
 * 우선순위큐
 * https://www.acmicpc.net/problem/2075
 */
public class Solution2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    // 우선순위큐는 우선순위가 높은(숫자가 작은) 것부터 출력하는 것이 디폴트 => 큰 수부터 출력할 수 있도록 Collections.reverseOrder() 사용
    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

    // Queue 메소드 (문제 상황 有 => 예외(throw) vs null/false 반환)
    // add vs offer (추가, enqueue)
    // remove vs poll (삭제, dequeue)
    // element vs peek (검사, peek)
    for (int i = 0 ; i < n ; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0 ; j < n ; j++) {
        q.offer(Integer.parseInt(st.nextToken()));
      }
    }

    // N-1번째 큰 수까지 삭제
    for (int i = 0 ; i < n-1 ; i++) {
      q.poll();
    }

    System.out.println(q.poll());
    br.close();
  }
}
