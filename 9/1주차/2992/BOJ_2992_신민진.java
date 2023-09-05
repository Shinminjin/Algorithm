import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2992_신민진 {

    static String X; // 주어진 정수 X
    static int intX;
    static boolean[] visited; // 순열 순회 시, 숫자 선택여부 알려줌
    static int MIN = Integer.MAX_VALUE; // 최솟값 초기화

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = br.readLine();
        visited = new boolean[X.length()];
        intX = Integer.parseInt(X); // 순열 메서드에서 값 비교시 필요

        permutation(0, "", intX);
        System.out.println(MIN == Integer.MAX_VALUE ? 0 : MIN); //  최솟값 갱신여부로 최종결과 출력
    }

    // 순열 메서드
    private static void permutation(int cnt, String result, int x) {

        // 순열 결과
        if (cnt == X.length()) {
            int temp = Integer.parseInt(result); // int 형변환
            if (temp > x) { MIN = Math.min(MIN, temp); }; // result가 주어진 X보다 클 경우, 최솟값 갱신
            return;
        }

        for (int i=0; i<X.length(); i++) {
            if (visited[i]) { continue; } // 해당 숫자 선택했을 경우, 패스

            // 선택하지 않은 경우, 선택표시
            visited[i] = true;
            // 재귀 호출
            permutation(cnt+1, result+X.charAt(i), intX);
            // 선택 해제
            visited[i] = false;
        }
    }

}
