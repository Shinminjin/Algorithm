import java.io.BufferedReader;
// import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_14425_신민진 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // 테스트 케이스 확인(로컬)
        // System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> S = new HashSet<String>();
        for(int i=0; i<N; i++) {
            S.add(br.readLine());
        }

        int cnt = 0;
        for(int i=0; i<M; i++) {
            String checkStr = br.readLine();
            if (S.contains(checkStr)) {
                cnt = cnt + 1;
            }
        }
        
        br.close();
        System.out.println(cnt);
    }
    
}
