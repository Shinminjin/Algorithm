import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. BOJ_2577 숫자의 개수
 * 2. 배열: 배열을 사용하면 각 숫자에 대한 빈도수를 인덱스로 쉽게 접근하고,
 * 해당 값을 증가시키는 방식으로 문제해결이 가능하다.
 * 3. A × B × C의 결과에서 0부터 9까지 각각의 숫자가 몇 번 쓰였는지..
 * 4. O(1)
 */
public class BOJ_2577_신민진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numA = Integer.parseInt(br.readLine());
        int numB = Integer.parseInt(br.readLine());
        int numC = Integer.parseInt(br.readLine());

        // A * B * C 결과 계산
        int multipleResult = numA * numB * numC;

        int[] digitCount = new int[10];

        while (multipleResult > 0) {
            int digit = multipleResult % 10;
            digitCount[digit]++;
            multipleResult /= 10;
        }

        // 0부터 9까지의 각 숫자의 출현 횟수를 출력
        for (int count : digitCount) {
            System.out.println(count);
        }
    }
}
