import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
* 1. BOJ 5430 골드V
* 2. 덱: 양쪽 끝에서 삭제가능, 뒤집기 연산 최적화
* 3. 함수는 조합해서 한 번에 사용할 수 있다.
* 4. O(N)
*/
public class BOJ_5430_신민진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            for (int i = 0; i < n; i++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char command : commands.toCharArray()) {
                if (command == 'R') {
                    isReversed = !isReversed;
                } else if (command == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            }
        }

        System.out.print(sb);
    }
}
