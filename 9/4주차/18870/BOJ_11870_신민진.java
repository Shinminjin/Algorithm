import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_11870_신민진 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        Set<Integer> numberSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            numberSet.add(numbers[i]);
        }

        List<Integer> numberArray = new ArrayList<>(numberSet);
        Collections.sort(numberArray);

        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i=0; i<numberArray.size(); i++) {
            numberMap.put(numberArray.get(i), i);
        }

        for (int i=0; i<N; i++) {
            sb.append(numberMap.get(numbers[i]) + " ");
        }

        System.out.println(sb);
    }
}
