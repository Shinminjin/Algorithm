import java.io.*;
import java.util.*;

/**
 * BOJ 18870 좌표 압축
 * 
 * 시간 제한 때문에 3번 트라이함
 * 정렬된 ArrayList를 두고 indexOf로 숫자의 인덱스를 반환하는 식으로 했는데
 * indexOf의 경우 O(N)이기 때문에 숫자가 100만개일 경우 100만^2으로 시간 초과가 발생했다.
 * 
 * 그래서 정렬 후, 각 숫자들의 index를 다 계산해두고 진행했음
 * 
 */
public class BOJ_18870 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> numberMap = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			
			// 중복제거용 hashMap
			numberMap.put(numbers[i], i);
		}
		
		// 중복 제거된 숫자들 정렬
		List<Integer> numberArray = new ArrayList<>(numberMap.keySet());
		Collections.sort(numberArray);
		
		// 압축된 좌표를 다시 hashMap에 저장
		for (int i = 0, size = numberArray.size(); i < size; i++) {
			numberMap.put(numberArray.get(i), i);
		}
		
		// 출력
		for (int i = 0; i < N; i++) {
			sb.append(numberMap.get(numbers[i]));
			
			if (i != N - 1) {
				sb.append(' ');
			}
		}
		
		System.out.println(sb);
		
	}

}
