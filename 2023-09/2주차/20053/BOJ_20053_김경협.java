import java.io.*;
import java.util.*;

/**
 * BOJ 20053 최소, 최대2
 * @author rudgu
 *
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            
            int N = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
            
            sb.append(min).append(' ').append(max);
            
            if (i != T - 1) {
                sb.append('\n');
            }
        }
        
        System.out.println(sb);
        
    }
}