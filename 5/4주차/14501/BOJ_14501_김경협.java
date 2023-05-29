import java.io.*;
import java.util.*;

/**
 * BOJ 14501 퇴사 하고싶다
 * 
 * DP, 수학
 * 
 */
public class BOJ_14501 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int currMax = 0;
		int[] time = new int[N + 1];
		int[] pay  = new int[N + 1];
		int[] dp   = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i]  = Integer.parseInt(st.nextToken());
		}
		
		// dp [i] -> i일에 얻을 수 있는 최대 수익
		// 현재 날짜 + payDate에 얻을 수 있는 수익을 업데이트해준다.
		for (int i = 0; i <= N; i++) {
			dp[i] = Math.max(dp[i], currMax);
			
			int payTime = time[i] + i;
			if (payTime <= N) {
				dp[payTime] = Math.max(dp[payTime], pay[i] + dp[i]);
			}
			
			currMax = Math.max(dp[i], currMax);
		}
		
		System.out.println(currMax);
	}

}
