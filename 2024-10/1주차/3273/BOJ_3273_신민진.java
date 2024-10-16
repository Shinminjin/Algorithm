import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
* 1. BOJ 3273 두 수의 합
* 2. 배열 : 고정된 크기의 수열을 효율적으로 저장하고, 빠르게 접근할 수 있다.
* 3. 두 수의 합이 x가 되는 경우의 수를 찾아라.
* 4. O(N)
*/
public class BOJ_3273_신민진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        
        int x = Integer.parseInt(br.readLine());

        int pairCount = 0; // 조건을 만족하는 쌍의 개수
        Set<Integer> checkedNumbers = new HashSet<>();
        for (int number : numbers) {
            int target = x - number; // 더해서 x가 되는 수를 찾음
            if (checkedNumbers.contains(target)) {
                pairCount++;
            }
            checkedNumbers.add(number);
        }

        System.out.println(pairCount);
    }
}
