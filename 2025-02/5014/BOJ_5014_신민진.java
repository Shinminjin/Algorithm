import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
* 1. BOJ 5014 스타트링크
* 2. BFS 알고리즘
* 3. 강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오.
* 4. O(N)
*/
public class BOJ_5014_신민진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int F = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int G = Integer.parseInt(input[2]);
        int U = Integer.parseInt(input[3]);
        int D = Integer.parseInt(input[4]);

        boolean[] visited = new boolean[F + 1];
        int[] moves = new int[F + 1]; // 각 층까지 이동하는 데 필요한 버튼 횟수 저장
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(S);
        visited[S] = true;
        
        boolean found = false;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == G) {
                System.out.println(moves[current]);
                found = true;
                break;
            }

            int nextFloor = current + U;
            if (nextFloor <= F && !visited[nextFloor]) {
                visited[nextFloor] = true;
                moves[nextFloor] = moves[current] + 1;
                queue.offer(nextFloor);
            }

            nextFloor = current - D;
            if (nextFloor >= 1 && !visited[nextFloor]) {
                visited[nextFloor] = true;
                moves[nextFloor] = moves[current] + 1;
                queue.offer(nextFloor);
            }
        }
        
        if (!found) {
            System.out.println("use the stairs");
        }
    }
}
