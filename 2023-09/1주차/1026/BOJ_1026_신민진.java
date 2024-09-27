import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1026_신민진 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long result = 0; // S의 최솟값

        int N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i=0; i<N; i++) {
            result += A[i] * B[i];
        }

        System.out.println(result);
    }
    
}
