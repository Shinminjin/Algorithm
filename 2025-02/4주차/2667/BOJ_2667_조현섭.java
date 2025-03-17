import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* 1. BOJ 2667 단지번호붙이기
* 2. BFS 알고리즘
* 3. 연결된 단지에대해 큐를 활용하여 방문체크하며 bfs로 풀이
* 4. O(N^2)
*/

public class Main {
	static int n, totCnt;
	static int[][] grp;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		grp = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j=0; j<n; j++)
				grp[i][j] = str[j] - '0';
		}
		List<Integer> danji = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(grp[i][j] > 0 && !visit[i][j]) {
					visit[i][j] = true;
					totCnt++;
					danji.add(bfs(i, j, 1));
				}
			}
		}
		sb.append(totCnt).append("\n");
		Collections.sort(danji);
		Iterator iter = danji.iterator();
		while(iter.hasNext())
			sb.append(iter.next()).append("\n");
		System.out.println(sb);
	}
	
	private static int bfs(int r, int c, int cnt) {
		Queue<Data> q = new LinkedList<Data>();
		q.offer(new Data(r, c));
		
		while(!q.isEmpty()) {
			Data tmp = q.poll();
			int curR = tmp.r;
			int curC = tmp.c;
			
			for(int d=0; d<4; d++) {
				int nr = dr[d] + curR;
				int nc = dc[d] + curC;
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) 
					continue;
				if(!visit[nr][nc] && grp[nr][nc] > 0) {
					visit[nr][nc] = true;
					q.offer(new Data(nr, nc));
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	private static class Data {
		int r;
		int c;
		Data(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
