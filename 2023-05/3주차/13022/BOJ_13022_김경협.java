import java.io.*;

public class BOJ_13022 {
	static int index = 0, inputLen = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		inputLen = input.length;
		int result = 1;
		
		// 단어 끝까지 탐색
		while (index < inputLen) {
			// 단어가 wolf 형식인지 체크
			if(!checkWolf(input)) {
				result = 0;
				break;
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean checkWolf(char[] input) {
		char[] charOrder = {'o', 'l', 'f'};
		int orderIdx = 0;
		int N = 0;
		
		// N 구하기
		while (input[index] == 'w') {
			index++;
			N++;

			// indexOut 체크
			if (index >= inputLen) return false;
		}
		
		// w 문자가 없는 경우,
		if (N == 0) return false;
		
		while (orderIdx < 3) {
			// N 만큼 다음 문자가 반복되는지 확인
			for (int i = 0; i < N; i++) {
				// indexOut 체크
				if (index >= inputLen) return false;

				if (input[index++] != charOrder[orderIdx]) {
					return false;
				}
			}
			orderIdx++;
		}
		// 모든 패턴 확인
		return true;
	}

}
