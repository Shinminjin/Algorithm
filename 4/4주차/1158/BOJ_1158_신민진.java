// import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158_신민진 {
    public static void main(String[] args) throws Exception {

        /* 
         *  offer(): 큐 맨 끝에 값 삽입
         *           값 추가 성공시 true, 실패 시 false 반환
         * 
         *  poll():  큐 맨 앞에 있는 값 반환 후 삭제
         *           큐가 비어있을 경우 null 반환
         */
        
        // 테스트 케이스 확인(로컬)
        // System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        
        // 큐 선언
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 1 ; i <= N; i++) {
            queue.offer(i);
        } // 1 부터 N 까지 큐에 값 삽입

        int[] answer = new int[N];
        int idx = 0;
        while(!queue.isEmpty()) {
            for (int i = 1; i < K ; i++) {
                queue.offer(queue.poll());
            } // K번째 전까지는 꺼내서 큐에 다시 담기
            int k_person = queue.poll();
            answer[idx++] = k_person;
        }

        System.out.print("<");
        for (int i = 0; i < N; i++) {
            if (i == N-1) {
                System.out.print(answer[i]);
            } else {
                System.out.print(answer[i] + ", ");
            }
        }
        System.out.print(">");
        sc.close();

    }
}

