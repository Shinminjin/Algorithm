import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이분탐색 알고리즘?
 * '정렬되어 있는 리스트'에서 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 방법
 * 
 * 구현 방법(How?)
 * 변수 3개(start, end, mid)를 사용하여
 * 찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교해서 원하는 데이터를 찾음
 */
public class BOJ_2512_신민진 {

    static int N; // 지방의 수
    static int[] budget; // 각 지방의 예산요청
    static int M; // 국가예산 총액

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        budget = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        // 이분탐색을 위해, 배열을 정렬해줌.
        Arrays.sort(budget);

        System.out.println(binarySearch());
    }
    
    /**
     * 이분탐색 구현
     * 로직설명
     * 
     * start(0), end(예산요청 최댓값) 초기화 후,
     * start가 end보다 커질 때까지 아래의 작업을 반복한다.
     * 
     *  1) start와 end의 중간 값을 구해 mid에 할당.
     *  2) 예산요청의 누적합을 담을 tempSum 변수를 0으로 초기화
     *  3) 각 지방의 예산요청(budget)을 mid 값(상한액)과 비교.
     *     해당요소가 mid 값(상한액) 이하일 경우, 상한액을 넘지않으므로 그 값을 tempSum에 누적.
     *     해당요소가 mid 값(상한액) 초과일 경우, mid 값을 tempSum에 누적.
     * 
     *  4) for문을 다 돌았을 때, 누적합(tempSum)을 국가예산총액(M)과 비교
     *     누적합(tempSum)이 국가예산총액(M)이하일 경우, mid를 더 높게 잡을 수 있으므로 mid+1을 start에 갱신.
     *     누적합(tempSum)이 국가예산총액(M)보다 클 경우, mid를 더 낮게 잡아야 하므로, mid-1을 end에 갱신.
     * 
     */
    private static int binarySearch() {
        int start = 0;
        int end = budget[N-1]; // 예산요청 최댓값
        
        while (start <= end) {
            int mid = (start + end) / 2; // 상한액
            int tempSum = 0;

            for (int i=0; i<N; i++) {
                if (budget[i] <= mid) {
                    tempSum += budget[i];
                } else {
                    tempSum += mid;
                }
            }

            if (tempSum <= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }    
}
