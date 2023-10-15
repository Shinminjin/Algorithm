import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2606_신민진 {

    static ArrayList<Set<Integer>> graph = new ArrayList<>(); // 연결상태
    static boolean[] visit; // 방문여부
    static int cnt = 0; // 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computerNum = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int connectedPairNum = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수

        // 그래프 생성
        for (int i=0; i<=computerNum; i++) {
            graph.add(new HashSet<>());
        }
        for (int i=0; i<connectedPairNum; i++) {
            st = new StringTokenizer(br.readLine());
            int st1 = Integer.parseInt(st.nextToken());
            int st2 = Integer.parseInt(st.nextToken());
            
            graph.get(st1).add(st2);
            graph.get(st2).add(st1);
        }

        // dfs 탐색
        visit = new boolean[computerNum+1];
        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int node) {
        visit[node] = true;
        for (int i: graph.get(node)) {
            if (!visit[i]) {
                visit[i] = true;
                cnt++;
                dfs(i);
            }
        }
    }
}
