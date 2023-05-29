import java.io.*;

/**
 * BOJ_15624 피보나치 수열
 * 
 */
public class BOJ_15624 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int MOD = 1000000007;
		
		int[] fib = new int[N + 1];
		
		// 조건문: 자연수 0, 1, 2에 대한 예외 처리
		if (N > 0) { fib[1] = 1; }
		if (N > 1) { fib[2] = 1; }
		
		// 피보나치 계산
		for (int i = 3; i < N + 1; i++) {
			fib[i] = (fib[i - 1] + fib[i - 2]) % MOD ;
		}
		
		System.out.println(fib[N]);
	}
}
