import java.io.*;

/**
 * BOJ 2849
 * 
 * 그리디, 5부터 채우고 남는자리 3주기
 * 안되면 5 하나씩 줄이면서 계속 시행
 *
 */
public class BOJ_2839 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int fiveCnt = N / 5 * 5;
		int remainder = N - fiveCnt;
		int threeCnt = remainder / 3 * 3;
		
		while (fiveCnt + threeCnt != N && fiveCnt > 0) {
			fiveCnt -= 5;
			remainder = N - fiveCnt;
			threeCnt = remainder / 3 * 3;
		}
		
		
		if (fiveCnt + threeCnt == N) {
			System.out.println(fiveCnt / 5 + threeCnt / 3);
		} else {
			System.out.println(-1);
		}
		
	}

}
