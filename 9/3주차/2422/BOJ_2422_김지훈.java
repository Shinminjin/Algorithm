import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2422_김지훈 {
    static int N; 
    static int M; 
    static int result = 0;
    
    static boolean[] visited;
    static int icecream[];
    static int tempArr[] = new int[3];
    
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(st.nextToken()); // 총 아이스크림 갯 수
       M = Integer.parseInt(st.nextToken()); // 섞으면 안되는 갯 수

       icecream = new int[N];
       
       for (int i=0; i<N; i++) {
    	   icecream[i] = i+1;
       }
       
       permutation(0, "", 3);
       
       st = new StringTokenizer(br.readLine());
       for (int i=0; i<M; i++) {
    	   
       }
    }
    public static void permutation(int cnt, String result, int r) {
    	if (cnt == r) {
    		System.out.println(result);
    		return;
    	}
    	for (int i=0; i<r; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			permutation(cnt + 1, result + icecream[i], r);
    			visited[i] = false;
    		}
    	}
    }
}
