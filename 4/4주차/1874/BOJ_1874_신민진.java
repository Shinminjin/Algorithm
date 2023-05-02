// import java.io.FileInputStream;
import java.util.*;

public class BOJ_1874_신민진 {

    public static void solve(int[] a) {
        Stack<Integer> stack = new Stack<Integer>();
        int m = 0;
        StringBuilder sb = new StringBuilder();
        for (int x : a) {
            if (x > m) {
                while (x > m) {
                    stack.push(++m);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.peek() != x) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        
        // 테스트 케이스 확인(로컬)
        // System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        solve(a);
        sc.close();
    }
    
}

