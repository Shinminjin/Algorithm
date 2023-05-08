import java.io.BufferedReader;
// import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2075_신민진 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        // 테스트 케이스 확인(로컬)
        // System.setIn(new FileInputStream("input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N*N];
        int idx = 0;

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[idx] = Integer.parseInt(st.nextToken());
                idx = idx + 1;
            }
        }
        br.close();

        Arrays.sort(arr);
        System.out.println(arr[N*N-N]);
    }
}
