import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 1764 듣보잡
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Boolean> map = new HashMap<>();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < N; i++) 
			map.put(br.readLine(), true);
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if(map.get(str) != null) {
				list.add(str);
			}
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for(String str : list) {
			sb.append(str).append("\n");
		}
		System.out.println(sb);
	}

}
