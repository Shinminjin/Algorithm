import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_신민진 {
    static int N;
    static int[] numbers;
    static int[] operator = new int[4];

    static int MAX = Integer.MIN_VALUE; // 최댓값 초기화
    static int MIN = Integer.MAX_VALUE; // 최솟값 초기화

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        
        // N개의 수
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // N-1개의 연산자
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, numbers[0]);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int i, int n) {
        // 종료조건
        if (i == N-1) {
            if (MAX < n) MAX = n;
            if (MIN > n) MIN = n;
            return;
        }

        for (int j=0; j<4; j++) {
            // 남은 연산자 없으면 넘어가기
            if(operator[j] <= 0) continue;

            operator[j]--;
            switch(j) {
                case 0: dfs(i+1, n+numbers[i+1]); break;
                case 1: dfs(i+1, n-numbers[i+1]); break;
                case 2: dfs(i+1, n*numbers[i+1]); break;
                case 3: dfs(i+1, n/numbers[i+1]); break;
            }
            operator[j]++;
        }
    }
}
