import java.util.*;
import java.io.*;

public class BOJ_1158_김경협 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		while (!que.isEmpty()) {
			
			for(int i = 1; i < K; i++) {
				que.offer(que.poll());
			}
			sb.append(que.poll()).append(", ");
			
		}
		
		sb.deleteCharAt(sb.length() - 1)
            .deleteCharAt(sb.length() - 1)
            .append('>');
		
		System.out.println(sb.toString());
	}

}