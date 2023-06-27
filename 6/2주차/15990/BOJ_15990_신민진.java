import java.io.*;

public class BOJ_15990_신민진 {
    public static void main(String[] args) throws Exception {
        
        long[][] dp = new long[100001][4];
        int mod = 1000000009; // 나누는 수
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        // 초기값 설정
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i=4; i<=100000; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % mod;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % mod;
        }

        for(int j=0; j<T; j++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % mod);
        }

    }
}
