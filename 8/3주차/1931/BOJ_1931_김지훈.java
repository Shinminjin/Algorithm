import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_김지훈 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());

        int[][] mettingArr = new int[(int)N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            mettingArr[i][0] = Integer.parseInt(st.nextToken());
            mettingArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(mettingArr, Comparator.comparingLong((int[] o) -> o[1]));
        Arrays.sort(mettingArr, Comparator.comparingLong((int[] o) -> o[0]));

        int result = 0;
        int stDt = 0;
        for (int i=0; i<mettingArr.length; i++) {
            if (mettingArr[i][0] >= stDt) {
                stDt = mettingArr[i][1];
                result += 1;
            }
        }
        System.out.println(result);
    }
}   