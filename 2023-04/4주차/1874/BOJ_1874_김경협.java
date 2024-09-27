import java.util.*;
import java.io.*;

public class BOJ_1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		int highestNum = 0;
		
		
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(br.readLine());
			
			if (highestNum < target) {
				for (int j = highestNum + 1; j <= target; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				
				stack.pop();
				sb.append("-\n");
				highestNum = target;
			} else {
				
				if (stack.isEmpty() || stack.peek() != target) {
					sb = new StringBuilder();
					sb.append("NO");
					break;					
				} else {
					stack.pop();
					sb.append("-\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}