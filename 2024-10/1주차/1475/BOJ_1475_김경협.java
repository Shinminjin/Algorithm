import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1475_김경협 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] countDashBoard = new int[10];

        for (int i = 0; i < input.length(); i++) {
            int currNumber = input.charAt(i) - '0';
            // 6이나 9일 경우, 더 적은 곳에 입력
            if (currNumber == 6 || currNumber == 9) {
                if (countDashBoard[6] > countDashBoard[9]) {
                    currNumber = 9;
                } else {
                    currNumber = 6;
                }
            }

            countDashBoard[currNumber]++;
        }

        // 초기 최대값은 배열의 첫 번째 값으로 설정
        int max = countDashBoard[0];
        
        // 배열을 순회하면서 최대값 찾기
        for (int i = 1; i < countDashBoard.length; i++) {
            if (countDashBoard[i] > max) {
                max = countDashBoard[i];
            }
        }

        System.out.println(max);
    }
}
