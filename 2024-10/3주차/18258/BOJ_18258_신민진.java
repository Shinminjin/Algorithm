import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
* 1. BOJ 18258 큐2
* 2. 큐: FIFO(First In, First Out)
* 3. pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 
*    만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
* 4. O(N)
*/
public class BOJ_18258_신민진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            switch (order) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue.add(x);
                    break;
                    
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                    break;
                    
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                    
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                    
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;
                    
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                    break;
            }
        }
        
        System.out.print(sb);
    }
}
