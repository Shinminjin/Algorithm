import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_신민진 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 삼각형 크기
        int[][] triangles = new int[n][n]; // 정수 삼각형

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<=i; j++) {
                triangles[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 뒤에서부터
        for (int i=n-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                triangles[i-1][j] += Math.max(triangles[i][j], triangles[i][j + 1]);
            }
        }

        System.out.println(triangles[0][0]);
    }
}
