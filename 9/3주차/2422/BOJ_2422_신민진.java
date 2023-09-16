import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2422_신민진 {
    static int N; // 아이스크림 종류 수
    static int M; // 섞어먹으면 안되는 조합의 수
    static boolean[][] noMixed; // 섞어먹으면 안되는 조합

    // 조합관련 변수
    static int icecream[] = new int[3]; // 아이스크림 3가지
    static boolean[] visited; // 조합순회 시, 선택여부 알려줌.
    static int result; // 최종 결과

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 아이스크림 종류
        M = Integer.parseInt(st.nextToken()); // 섞어먹으면 안되는 조합의 개수
        noMixed = new boolean[N+1][N+1]; // 섞어먹으면 안되는 조합
        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            noMixed[x][y] = true;
            noMixed[y][x] = true;
        }

        combination(0, 0);
        System.out.println(result);
    }

    // 조합
    private static void combination(int cnt, int idx) {
        if(cnt == 3) {
            // 섞어먹어도 괜찮은 조합이면 result에 합산.
            if(!isNotMixed()) { result++; }
            return;
        }

        for(int i=1; i<=N; i++) {
            if (visited[i]) { continue; } // 선택된 조합일 경우, 패스
            
            // 조합조건
            if (i > idx) {
                visited[i] = true;
                icecream[cnt] = i;
                combination(cnt+1, i);
                visited[i] = false;
            }
        }
    }

    // 섞어먹으면 안되는 조합인지 체크
    private static boolean isNotMixed() {
        int a = icecream[0];
        int b = icecream[1];
        int c = icecream[2];

        // 섞어먹으면 안되는 조합일 경우
        if (noMixed[a][b] || noMixed[b][c] || noMixed[c][a]) {
            return true;
        }
        return false;
    }
}
