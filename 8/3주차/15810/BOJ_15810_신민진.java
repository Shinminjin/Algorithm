import java.io.*;
import java.util.*;

public class BOJ_15810_신민진 {

    // 시간 쌍을 담기위한 클래스
    static class Pair implements Comparable<Pair> {
        int makingTime; // 풍선하나 만드는데 걸리는 시간(필요시간)
        long finishTime; // 누적시간

        public Pair(int makingTime, long finishTime) {
            this.makingTime = makingTime;
            this.finishTime = finishTime;
        }

        @Override
        public int compareTo(Pair o) {
            return this.finishTime > o.finishTime ? 1 : -1;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 스태프의 수
        int M = Integer.parseInt(st.nextToken()); // 풍선의 개수

        // 필요작업시간, 누적작업시간을 우선순위큐에 담는다.
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        st = new StringTokenizer(br.readLine()); // 스태프들이 풍선을 만드는데 걸리는 시간

        for(int i=0; i<N; i++) {
            int staffMakingTime = Integer.parseInt(st.nextToken()); // 각 스태프가 풍선 하나를 만드는 데 걸리는 시간
            pq.offer(new Pair(staffMakingTime, staffMakingTime));
        }

        int total = 0; // 만들어지는 풍선개수 초기화
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            total++;
            //풍선개수가 M이 될 때의 최소시간
            if(total == M) {
                System.out.println(pair.finishTime);
                break;
            } else {
                pq.offer(new Pair(pair.makingTime, pair.finishTime + pair.makingTime));
            }
        }
    }
}
