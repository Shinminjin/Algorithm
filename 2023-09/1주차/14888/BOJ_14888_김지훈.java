import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_김지훈 {
    public static int Max = Integer.MIN_VALUE;
    public static int Min = Integer.MAX_VALUE;
    public static int[] operator = new int[4];
    public static int[] numbers;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(Max);
        System.out.println(Min);
    }

    public static void dfs(int n, int i) {
        if (i == N) {
            Max = Math.max(Max, n);
            Min = Math.min(Min, n);
            return;
        }

        for (int j=0; j<4; j++) {
            if (operator[j] > 0) {
                operator[j]--;

                switch(j) {
                    case 0: dfs(n + numbers[i], i+1); break;
                    case 1: dfs(n - numbers[i], i+1); break;
                    case 2: dfs(n * numbers[i], i+1); break;
                    case 3: dfs(n / numbers[i], i+1); break;
                }

                operator[j]++;
            }
        }
    }
}
