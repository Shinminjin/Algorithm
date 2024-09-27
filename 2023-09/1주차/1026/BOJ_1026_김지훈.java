
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1026_김지훈 {
    public static void main(String[] args) throws IOException{
        long result = 0;

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        Integer[] A = new Integer[(int)N];
        Integer[] B = new Integer[(int)N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken()) ;
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            B[i] = Integer.parseInt(st.nextToken()) ;
        }

        // 로직
        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        for (int i=0; i<N; i++) {
            result += A[i] * B[i];
        }

        System.out.println(result);
    }
}
