import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15624_신민진 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        
        if (n == 0) dp[0] = 0;
        else if (n == 1) dp[1] = 1;
        else {
            for (int i=2; i<=n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
            }
        }
        System.out.println(dp[n]);
    }
}
