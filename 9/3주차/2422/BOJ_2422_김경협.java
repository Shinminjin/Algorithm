import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2422 한윤정~
 * 
 * 조합 문제
 */
public class BOJ_2422 {
	private static int combCnt = 0, N, M, selectedNum[];
	static boolean doNotMixMap[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 먹으면 안되는 조합 맵
		doNotMixMap = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			doNotMixMap[a][b] = true;
			doNotMixMap[b][a] = true;
		}
		
		selectedNum = new int[3];
		
		// 3가지 종류를 선택하는 조합 시작
		for (int i = 1; i <= N; i++) {
			selectedNum[0] = i;
			combination(1, i);
		}
		
		System.out.println(combCnt);
	}
	
	static void combination(int depth, int startNum) {
		// 3가지 조합 선택 완료
		if (depth == 3) {
			combCnt++;
			return;
		}
		
		for (int i = startNum + 1; i <= N; i++) {
			
			// 섞어도 되는지 확인
			boolean doNotMix = false;
			
			for (int j = 0; j < depth; j++) {
				if (doNotMixMap[i][selectedNum[j]]) {
					doNotMix = true;
					break;
				}
			}
			
			if (doNotMix) { continue; }
			
			// 다음 조합 수 선택
			selectedNum[depth] = i;
			combination(depth + 1, i);
		}
	}
	
}
 