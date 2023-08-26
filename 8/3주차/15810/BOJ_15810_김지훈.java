import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15810_김지훈 {
    public static void main(String[] args) throws IOException {
      // 입력
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      long N = Integer.parseInt(st.nextToken());
      long M = Integer.parseInt(st.nextToken());
      
      List<Integer> staffTimeList = new ArrayList<>();
      st = new StringTokenizer(br.readLine());
      long min = Integer.MAX_VALUE;
      for (int i=0; i<N; i++) {
          staffTimeList.add(Integer.parseInt(st.nextToken()));
          min = Math.min(min, staffTimeList.get(i));
      }

      long left = 0;
      long right = min * M;

      // 로직
      while (left + 1 < right) {
          long mid = (left+right)/2;
          long balloon = 0;
          for (Integer i : staffTimeList) {
              balloon += (mid / i) ;
          }

          if (balloon >= M) {
              right = mid;
          }
          else {
              left = mid;
          }
      }
      // 최소 값을 구해야 하므로, right     
      System.out.println(right);
  }
}