import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20053_신민진 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine()); // 정수의 개수
            int MIN = Integer.MAX_VALUE; // 최솟값 초기화
            int MAX = Integer.MIN_VALUE; // 최댓값 초기화

            st = new StringTokenizer(br.readLine(), " "); // 공백구분
            for(int j=0; j<N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                // 최대 최소 갱신
                if(MAX < temp) MAX = temp;
                if(MIN > temp) MIN = temp;
            }
            sb.append(MIN + " " + MAX + "\n");
        }
        System.out.println(sb);
    }
}
