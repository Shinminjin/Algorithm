import java.io.*;
import java.util.*;

public class BOJ_1931_신민진 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 종료시간 같을 경우, 시작시간이 빠른 순으로 정렬
        Queue<int[]> queue = new PriorityQueue<>((m1, m2) -> {
            if (m1[1] == m2[1]) {
                return m1[0] - m2[0];
            }
            else return m1[1] - m2[1];
        });

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.offer(new int[]{
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            });
        }

        int cnt = 0;
        int end = 0; // 종료시간 초기화

        while(!queue.isEmpty()) {

            int[] temp = queue.poll();

            // 다음 회의 시작시간이
            // 직전 종료시간보다 크거나 같을 경우
            if (temp[0] >= end) {
                end = temp[1]; // 종료시간 갱신
                cnt++;
            }
        }

        System.out.println(cnt);
        
    }
}
