import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1764_신민진 {
    static int N;
    static int M;
    static HashSet<String> set;
    static List<String> result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수(N)
        M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수(M)
        
        // 듣도 못한 사람의 명단
        set = new HashSet<String>();
        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }

        result = new ArrayList<>();
        for(int i=0; i<M; i++) {
            String temp = br.readLine(); // 보도 못한 사람의 명단

            // 듣도 보도 못한 사람 명단생성
            if(set.contains(temp)) {
                result.add(temp);
            }
        }

        // 사전순 정렬
        Collections.sort(result);
        for(String str : result) {
            sb.append(str).append("\n");
        }

        System.out.println(result.size()); // 듣보잡 수
        System.out.println(sb); // 듣보잡 명단
    }
}
