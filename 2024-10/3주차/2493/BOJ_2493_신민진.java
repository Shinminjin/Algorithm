import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

/**
* 1. BOJ 2493 탑
* 2. 스택 : 스택에 있는 탑 중 자신보다 낮은 탑을 모두 제거한다.
* 3. 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다.
* 4. O(N)
*/
public class BOJ_2493_신민진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            int topHeight = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek()[1] < topHeight) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek()[0] + 1;
            } else {
                result[i] = 0;
            }

            stack.push(new int[] {i, topHeight});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
