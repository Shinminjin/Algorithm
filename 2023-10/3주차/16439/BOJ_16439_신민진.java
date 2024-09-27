import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16439_신민진 {
    static int N; // 고리 회원의 수
    static int M; // 치킨 종류 수
    static int[][] preference; // 치킨선호도

    // 조합관련 변수
    static boolean[] visit;
    static int maxSum = Integer.MIN_VALUE; // 만족도합 최댓값

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        preference = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; j++) {
                preference[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[M];
        combination(0, 0);
        System.out.println(maxSum);
    }

    static void combination(int depth, int startNum) {
        // 치킨 조합 3개 선택되었을 때
        if (depth == 3) {
            int tempSum = 0;
            for (int i=0; i<N; i++) {
                int temp = 0;
                for (int j=0; j<M; j++) {
                    if (!visit[j]) { continue; }
                    temp = Math.max(temp, preference[i][j]); 
                }
                tempSum += temp;
            }
            maxSum = Math.max(maxSum, tempSum); // 만족도 합 최댓값 갱신
        }

        for (int i=startNum; i<M; i++) {
            if (visit[i]) { continue; }
            visit[i] = true;
            combination(depth+1, i+1);
            visit[i] = false;
        }
    }
}
