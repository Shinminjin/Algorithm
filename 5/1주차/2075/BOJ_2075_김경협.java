import java.util.*;
import java.io.*;

public class BOJ_2075 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				pq.offer(num);
				
				if(pq.size() > N) {
					pq.poll();
				}
			}
		}
		
		System.out.println(pq.poll());
	}
}
