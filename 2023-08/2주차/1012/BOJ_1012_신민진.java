import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1012_신민진 {
	
	static int M; // 배추밭의 가로길이
	static int N; // 배추밭의 세로길이
	static int K; // 배추가 심어져 있는 위치개수

	static int[][] cabbage; // 배추밭

	static boolean[][] visit; // 방문여부

	// 동서남북
	static int[] dx = {1, -1, 0, 0}; // 가로
	static int[] dy = {0, 0, -1, 1}; // 세로

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			String[] temp = br.readLine().split(" ");

			M = Integer.parseInt(temp[0]);
			N = Integer.parseInt(temp[1]);

			int K = Integer.parseInt(temp[2]); // 배추개수

			cabbage = new int[M][N];
			visit = new boolean[M][N];

			// 배추 심어져 있는 땅
			for(int i=0; i<K; i++) {
				temp = br.readLine().split(" ");
				int x = Integer.parseInt(temp[0]);
				int y = Integer.parseInt(temp[1]);
				cabbage[x][y] = 1;
			}

			// 흰 지렁이 수
			int bugs = 0;
			for (int y=0; y<N; y++) {
				for (int x=0; x<M; x++) {
					// 배추가 방문하지 않은 곳에 있을 경우
					if(cabbage[x][y] == 1 && !visit[x][y]) {
						bugs++;
						dfs(x, y);
					}
				}
			}

			// 지렁이 수 출력
			System.out.println(bugs);
		}
	}

	// 깊이우선탐색
	public static void dfs(int x, int y) {
		visit[x][y] = true;

		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위안에서 && 배추가 있고 && 방문하지 않았으면
			if(((nx>=0 && nx<M) && (ny>=0 && ny<N)) && cabbage[nx][ny]==1 && !visit[nx][ny]) {
				// dfs 탐색
				dfs(nx, ny);
			}
		}
	}
}
