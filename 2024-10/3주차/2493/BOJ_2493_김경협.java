import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_김경협 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] heights = new int[N], results = new int[N];
        
		Stack<Integer> stk = new Stack<>();
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++)
			heights[i] = Integer.parseInt(tk.nextToken());

		for(int i = N - 1; i >= 0; i--) {
			if(stk.isEmpty())
				stk.push(i);
			else {
				while(!stk.isEmpty() && heights[stk.peek()] <= heights[i]) {
					results[stk.pop()] = i + 1;
				}
				
				stk.push(i);
			}		
		}

		StringBuilder sb = new StringBuilder();
		for(int result : results)
			sb.append(result).append(' ');
		
		System.out.println(sb);
		
	}
}