package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_13022_황배근 {
	
	static char[] match = {'w', 'o', 'l', 'f' };
	
	public static int solution(String s) {
			
			int answer = 1;
			int idx = 0;
			int Charcnt =0 ; // w 이후 문자의 개수
			int Windex =0;
			// 첫 글자가 w 가 아니라면 , 탈락
			if ( s.charAt(0) != match[0]) return 0;
			
			// wcount 담아두자.
			ArrayList<Integer> wcount = new ArrayList<>();
			for ( int i=0; i<s.length(); i++) {
				if ( s.charAt(i) == 'w') {
					Charcnt ++;
				}
				// 같지 않을 때는 초기화
				else {
					// 그전에 w가 있었고, 이번에 w가 없을 경우
					if ( Charcnt > 0) {
						wcount.add(Charcnt);
						Charcnt =0;
					}
				}
				
			}
			Charcnt=1; // 여기까지 온거면 첫 글자는 무조건 w임.
			for( int i=1; i<s.length(); i++) {
				
				// 이전 문자랑 같은지먼저!
				if ( s.charAt(i-1) == s.charAt(i)) {
					// match[idx]랑 비교하고
					if( s.charAt(i) == match[idx]) {		
						Charcnt ++;
					} else {
						return 0;
					}
				}
				// 이전 문자랑 다를 때 ! 
				else {
					// 기록된 Charcnt가 wcount랑 다르면 안됨
					if ( Charcnt != wcount.get(Windex) ) {
						return 0;
					}
	
					// 달라졌는데 이전문자가 f야 ==> 새로운 w가 등장했다는 소리
					if (s.charAt(i-1) == 'f' ) {
						idx = -1;
						Windex++;
					}
					
					// 이전문자랑 다르고 match[++idx]랑 비교하고 같으면 Charcnt = 1로 초기화
					if ( s.charAt(i) == match[++idx]) {
						
						Charcnt =1;
					} else {
						return 0;
					}
					
				}
			}
			// 마지막은 f로 끝나야하고 f의 개수가 w의 개수랑 다르다면  
			if ( idx != 3 || Charcnt != wcount.get(Windex)) return 0;
			
			return answer ;
		}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		
		System.out.println(solution(input));
	}

}