import java.io.*;
import java.util.*;

/** 3kg, 5kg 최소 봉지 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int w = N; // weight
        if(w >= 5 & w % 5 == 0){ // 5kg 로만 들수있는지 체크
            int kg5 = w/5;
            System.out.println(kg5);
            return; 
        }
        else {
            int i;
            for(i = 1 ; i * 3 < N ; i++){
                w = N - (3 * i);
                if(w >= 5 && w % 5 == 0){
                    int kg5 = w / 5;
                    System.out.println(kg5+i);
                    return;
                }
                else if(w < 3){
                    System.out.println(-1);
                    return;
                }
                else{
                    continue;
                }
            }
            System.out.println(i);
            return;
        }
    }
}
