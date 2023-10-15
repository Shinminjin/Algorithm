import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9655_신민진 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 돌 개수
        int[] dp = new int[1001]; // 게임 몇번 했는지

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=N; i++) {
            dp[i] = Math.min(dp[i-1]+1, dp[i-3]+1);
        }

        System.out.println(dp[N] % 2 == 1 ? "SK" : "CY");
    }
}
