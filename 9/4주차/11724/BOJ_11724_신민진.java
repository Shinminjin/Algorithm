import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724_신민진 {
    static int N; // 정점 개수
    static int M; // 간선 개수
    static int graph[][]; // 연결상태
    static boolean[] visit; // 방문여부

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];     
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        visit = new boolean[N+1];
        int result = 0; // 연결요소 개수
        for (int i=1; i<=N; i++) {
            if (!visit[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

    static void dfs(int startNode) {
        visit[startNode] = true;

        for (int i=1; i<=N; i++) {
            if (graph[startNode][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }

    }
}
