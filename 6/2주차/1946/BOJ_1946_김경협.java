import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1946 신입사원
 * 
 * 그리디
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] scoreList = new int[N+1];
			
			int min = Integer.MAX_VALUE;
			
            // 각 지원자 서류심사 성적 - 면접 성적 맵핑
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int score1 = Integer.parseInt(st.nextToken());
				int score2 = Integer.parseInt(st.nextToken());
				scoreList[score1] = score2;
			}
			
            // 서류심사 1등부터 ~ 꼴등까지 진행
            // 서류 2등은 1등의 면접 순위와 비교
            // ...
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if(scoreList[i] < min) {
					cnt++;
					min = scoreList[i];
				}
			}

			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
