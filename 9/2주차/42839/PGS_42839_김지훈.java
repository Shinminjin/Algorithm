import java.util.HashSet;
import java.util.Set;

public class PGS_42839_김지훈 {

	Set<Integer> set;
	boolean[] visited;
	String[] part;
    
    public int solution(String numbers) {
        int answer = 0;
        
        set = new HashSet<Integer>();
		visited = new boolean[numbers.length()];
		part = numbers.split("");
		
        // 순열로 만들 수 있는 모든 수를 구함
		permutation(0, "");
		
		// 순열로 구한 수에서, 소수 판별
		for (int s : set) {
			if (isPrime(s)) {
				answer += 1;
			}
		}
        
        return answer;
    }

    private void permutation(int index, String sum) {
		if (!sum.isEmpty()) {
			set.add(Integer.parseInt(sum));
		}
		for (int i=0; i<part.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permutation(index + 1, sum + part[i]);
				visited[i] = false;
			}
		}
	}
    
    private boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		
        for (int i=2; i<num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
