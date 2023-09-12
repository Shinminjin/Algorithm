import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
        	int N = Integer.parseInt(br.readLine());
            int max = -1000001;
            int min = 1000001;
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j=0;j<N;j++){
                int x = Integer.parseInt(st.nextToken());
                max = max < x ? x : max ;
                min = min > x ? x : min ; 
            }
        	System.out.print(min + " " + max + "\n");
        }
    }
}
