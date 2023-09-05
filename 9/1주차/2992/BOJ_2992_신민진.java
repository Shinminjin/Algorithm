import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BOJ_2992_신민진 {

    static int X; // 주어진 정수 X
    static int[] X_arr; // 순열 순회 대상
    static boolean[] visited; // 순열 순회 시, 숫자 선택여부 알려줌
    static int MIN = Integer.MAX_VALUE; // 최솟값 초기화

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());

        // X를 array 형태로 반환
        X_arr = Stream.of(String.valueOf(X).split("")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[X_arr.length];

        permutation(0, "");
        System.out.println(MIN == Integer.MAX_VALUE ? 0 : MIN); //  최솟값 갱신여부로 최종결과 출력
    }

    // 순열 메서드
    private static void permutation(int cnt, String result) {

        // X길이 만큼 선택됨(순열 결과)
        if (cnt == X_arr.length) {
            int temp = Integer.parseInt(result); // int 형변환
            if (temp > X) { MIN = Math.min(MIN, temp); }; // result가 주어진 X보다 클 경우, 최솟값 갱신
            return;
        }

        for (int i=0; i<X_arr.length; i++) {
            if (visited[i]) { continue; } // 해당 숫자 선택했을 경우, 패스

            // 선택하지 않은 경우, 선택표시
            visited[i] = true;
            // 재귀 호출
            permutation(cnt+1, result+X_arr[i]);
            // 선택 해제
            visited[i] = false;
        }
    }

}
