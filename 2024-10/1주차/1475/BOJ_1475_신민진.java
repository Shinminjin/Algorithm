import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* 1. BOJ 1475 방번호
* 2. 배열: 숫자 0부터 9까지의 빈도수를 효율적으로 저장하고 관리하기 위해서
* 3. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
* 4. O(N): 입력된 방 번호의 길이 만큼 반복됨.
*/
public class BOJ_1475_신민진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNumber = br.readLine();
        
        // 0부터 9까지 각 숫자의 빈도를 저장할 배열
        int[] digitCount = new int[10];
        
        // 각 숫자의 빈도를 계산
        for (int i = 0; i < roomNumber.length(); i++) {
            int digit = roomNumber.charAt(i) - '0';
            digitCount[digit]++;
        }
        
        int sixNineCount = digitCount[6] + digitCount[9];
        digitCount[6] = (sixNineCount + 1) / 2;
        digitCount[9] = 0;
        
        int maxSetCount = 0;
        for (int count : digitCount) {
            maxSetCount = Math.max(maxSetCount, count);
        }

        System.out.println(maxSetCount);
    }
}
