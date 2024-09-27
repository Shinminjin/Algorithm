import java.io.BufferedReader;
import java.util.StringTokenizer;

import jdk.internal.org.jline.utils.InputStreamReader;

public class BOJ_2512_±Ë¡ˆ»∆ {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] budgetArr = new int[N]; 
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			budgetArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		int left = 0;
		int right = M;
		int mid = 0;
		int sum = 0;		
		while (left < right) {
			sum = 0;
			mid = (left+rigth)/2;
			
			for (int i=0; i<N; i++) {
				if (budgetArr[i] < mid) {
					sum += budgetArr[i]
				} else {
					sum += mid
				}
			}
			
			if (sum < M) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
	}
}
