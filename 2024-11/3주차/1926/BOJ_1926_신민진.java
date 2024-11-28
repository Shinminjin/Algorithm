import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
* 1. BOJ 1926 그림
* 2. BFS 알고리즘: 가로 세로 연결된 영역을 탐색
* 3. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다.
*    -> 상하좌우 탐색이 필요한 문제라는걸 파악
* 4. O(n * m)
*/
public class BOJ_1926_신민진 {
    static int n, m;
    static int[][] canvas;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        n = Integer.parseInt(dimensions[0]);
        m = Integer.parseInt(dimensions[1]);
        
        canvas = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                canvas[i][j] = Integer.parseInt(line[j]);
            }
        }

        int pictureCount = 0;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canvas[i][j] == 1 && !visited[i][j]) {
                    pictureCount++;
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }

        System.out.println(pictureCount);
        System.out.println(maxArea);
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int area = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            area++;

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && canvas[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return area;
    }
}
