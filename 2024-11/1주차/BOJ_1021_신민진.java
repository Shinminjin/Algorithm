import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
* 1. BOJ 1021 회전하는 큐
* 2. 덱 : 양방향으로 회전할 수 있는 자료구조가 필요함.
* 3. 원소를 주어진 순서대로 뽑아내는데 드는 
*    2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.
* 4. O(M * N)
*/
public class BOJ_1021_신민진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        Queue<Integer> que = new LinkedList<>();
        int cnt = 0; // 총 연산횟수
        for (int i = 0; i < M; i++) {
            while(deque.peekFirst() != position[i]) {
                que.offer(deque.poll());
            }

            if (que.size() < deque.size()) {
                cnt += que.size();
            } else {
                cnt += deque.size();
            }

            deque.poll();
            while (!que.isEmpty()) {
                deque.addLast(que.poll());
            }
        }
        System.out.print(cnt);
    }
}
