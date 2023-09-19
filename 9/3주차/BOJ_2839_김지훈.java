import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2839_������ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());

		// �ϴ� 5�� ������ �����ؾ� �ּ� ���� ���� ���� �� ����
		int p = N/5;
		int m = N%5;

		if (m == 0) {
			System.out.println(p);
		} 
		// 1, 6, 11, 16 
		else if (m == 1) {
			if (N < 5) {
				System.out.println(-1);
			}
			else {
				System.out.println(p-1 + 2);
			}
		}
		// 2, 7, 12 0 4, 17 1 4 2 4 3 4
		else if (m == 2) {
			if (p-2 < 0) {
				System.out.println(-1);
			}
			else {
				System.out.println(p-2 + 4);
			}
		}
		// 3 8 13
		else if (m == 3) {
			System.out.println(p + 1);
		}
		// 4 9 0 3 14 1 3 19 2 3 
		else if (m == 4) {
			if (p-1 < 0) {
				System.out.println(-1);
			}
			else {
				System.out.println(p-1 + 3);
			}
		}
	}
}
