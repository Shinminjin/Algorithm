import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 로직 설명
 * 5 x deliveryBag[0] + 3 x deliveryBag[1] = N
 * (deliveryBag[0] + deliveryBag[1]) 의 최솟값
 * 
 * 고려조건
 * 5kg 담는 봉지개수가 클수록 전체 봉지개수가 작음.
 * 
 * 1) deliveryBag[0] = N/5 으로 초기화
 * 2) deliveryBag[0]--
 * 3) break 조건에 걸리지 않으면 최종출력 -1
 */
public class BOJ_2839_신민진 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 배달해야할 설탕 (N)kg
        int[] deliveryBag = {0, 0}; // 배달봉지(5kg 개수/3kg 개수)

        deliveryBag[0] = N/5;
        while (deliveryBag[0] >= 0) {
            // break 조건
            if ((N - deliveryBag[0]*5) % 3 == 0) {
                deliveryBag[1] = (N - deliveryBag[0]*5) / 3;
                break;
            }
            deliveryBag[0]--;
        }

        System.out.println(deliveryBag[0] + deliveryBag[1]);
    }
}
