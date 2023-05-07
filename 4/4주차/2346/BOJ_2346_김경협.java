import java.io.*;
import java.util.*;

public class BOJ_2346 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] balloon = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			balloon[i] = Integer.parseInt(st.nextToken());
			deque.offer(i);
		}
		
		int index = deque.pollFirst();
		int command = balloon[index];
		
		sb.append(index).append(" ");
		
		while (!deque.isEmpty()) {
			for (int i = 1; i < Math.abs(command); i++) {
				if (command > 0) {
					deque.offerLast(deque.pollFirst());
				} else {
					deque.offerFirst(deque.pollLast());
				}
			}
			
			if (command > 0) {
				command = deque.pollFirst();
			} else {
				command = deque.pollLast();
			}
			sb.append(command).append(" ");
			command = balloon[command];
		}
		
		sb.deleteCharAt(sb.length() - 1);
		System.out.print(sb);
	}

}
