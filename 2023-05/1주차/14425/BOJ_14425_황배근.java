package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14425_황배근 {
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        int cnt = 0;

        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }
        for(int i=0; i<m; i++){
            String str = br.readLine();
            if (set.contains(str)) {
                cnt++;
            }
        }
          System.out.println(cnt);
      }
}
