package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2075_황배근 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> resList = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                resList.add(Integer.parseInt(st.nextToken()));
            }
        }
        resList.sort(Collections.reverseOrder());
        System.out.print(resList.get(N - 1));
    }
}
