import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
* 1. BOJ 2178 미로탐색
* 2. BFS 알고리즘
* 3. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
* 4. O(N * M)
*/
public class BOJ_2178_신민진 {
    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] dimensions = br.readLine().split(" ");
        n = Integer.parseInt(dimensions[0]);
        m = Integer.parseInt(dimensions[1]);
        
        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(new Point(0, 0));
        System.out.println(result);
    }

    static int bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == n - 1 && current.y == m - 1) {
                return maze[current.x][current.y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    maze[nx][ny] = maze[current.x][current.y] + 1; 
                }
            }
        }
        return -1;
    }
}
