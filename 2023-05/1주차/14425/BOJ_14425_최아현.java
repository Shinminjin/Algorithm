import java.io.*;
import java.util.*;
/* 문제 
총 N개의 문자열로 이루어진 집합 S가 주어진다.
입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
*/
public class BOJ_14425_최아현 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> hmap = new HashMap<>();
        int cnt = 0;
        
        for(int i=0; i<N; i++){
        	String str1 = br.readLine();
        	hmap.put(str1, 0);
        }
        for (int j=0; j<M; j++) {
        	String str2 = br.readLine();
            if (hmap.containsKey(str2)) {
            	cnt++;
            }
        }
        System.out.print(cnt);
    }

}
