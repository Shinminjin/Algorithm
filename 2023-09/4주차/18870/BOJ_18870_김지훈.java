import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_18870_김지훈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
        // set 으로 변경하여 중복제거
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(arr)); 
		
        Integer[] sortedArr = treeSet.toArray(new Integer[] {});
        
        // 오름차순 정렬
        Arrays.sort(sortedArr);

        ArrayList<Integer> arraylist = new ArrayList<>(Arrays.asList(sortedArr));

        HashMap<Integer, Integer> resultMap = new HashMap<>();

        for (int i=0; i<arraylist.size(); i++) {
            resultMap.put(arraylist.get(i), i);
        }
        
        StringBuilder result = new StringBuilder();

        // 이부분에서, 
		for (int i : arr) {
            result.append(resultMap.get(i) + " ");
            // System.out.print(arraylist.indexOf(i) + " "); 이런식으로 indexOf 쓰면 시간초과 -> resultMap 하나 생성
		}

        System.out.print(result);
	}
}