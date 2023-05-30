import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_14501 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N+1][2];
        int cnt = 0;
        
        String str;
        while((str = br.readLine()) != null) {        	 
    		st = new StringTokenizer(str);
    		array[cnt][0] = Integer.parseInt(st.nextToken());
    		array[cnt][1] = Integer.parseInt(st.nextToken());

    		cnt++;
        }
        
        int[] dp = new int[N+1];
        
        for (int i = 0; i < N; i++) {
			if (i + array[i][0] <= N) {
				dp[i + array[i][0]] = Math.max(dp[i + array[i][0]], dp[i] + array[cnt][1]);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[N]);
	}
}
