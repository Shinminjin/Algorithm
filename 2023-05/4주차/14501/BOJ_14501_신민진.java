import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_신민진 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] T = new int[N];
        int[] P = new int[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        
        for (int i=0; i<N; i++) {
            if (i + T[i] <= N) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}