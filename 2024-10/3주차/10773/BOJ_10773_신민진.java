import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

/**
* 1. BOJ 10773 제로
* 2. 스택 : LIFO(Last In, First Out)
* 3. 입력: 정수가 0 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
* 4. O(N)
*/
public class BOJ_10773_신민진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        
        int sum = 0;
        for (int number : stack) {
            sum += number;
        }
        
        System.out.println(sum);
    }
}
