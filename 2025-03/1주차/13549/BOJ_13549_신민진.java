import java.io.*;
import java.util.*;

/**
* 1. BOJ 13549 숨바꼭질 3
* 2. BFS 알고리즘
* 3. 수빈이가 걷는 경우는 1초 후에 이동하지만, 순간이동은 0초 후에 이동한다
* 4. O(N)
*/
public class BOJ_13549_신민진 {
    public static void main(String[] args) throws IOException {
        final int MAX_POSITION = 100000;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] minTime = new int[MAX_POSITION + 1];
        for (int i = 0; i <= MAX_POSITION; i++) {
            minTime[i] = Integer.MAX_VALUE;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        minTime[start] = 0;
        deque.offer(start);

        while (!deque.isEmpty()) {
            int pos = deque.poll();
            if (pos == target) {
                System.out.println(minTime[pos]);
                return;
            }

            // 순간이동
            int jumpPos = pos * 2;
            if (jumpPos <= MAX_POSITION && minTime[jumpPos] > minTime[pos]) {
                minTime[jumpPos] = minTime[pos];
                deque.offerFirst(jumpPos);
            }

            // 걷기
            int[] walkPositions = {pos - 1, pos + 1};
            for (int nextPos : walkPositions) {
                if (nextPos >= 0 && nextPos <= MAX_POSITION && minTime[nextPos] > minTime[pos] + 1) {
                    minTime[nextPos] = minTime[pos] + 1;
                    deque.offerLast(nextPos);
                }
            }
        }
    }
}

