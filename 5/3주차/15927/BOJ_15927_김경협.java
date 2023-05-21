import java.io.*;

public class BOJ_15927 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		
		System.out.println(getLongestSubStr(str));
	}

	private static int getLongestSubStr(char[] str) {
		boolean isSingleCharStr = true;
		
		// 회문 체크,
		// 회문 o --> 길이 - 1 만큼 부분문자열
		// 회문 x --> 길이만큼 부분문자열
		for(int i = 0, size = str.length; i < size / 2; i++) {
			if(str[i] != str[size - 1 - i]) return size;

			// 한글자로 된 회문은 부분문자열 없음
			if(str[i] != str[i + 1]) isSingleCharStr = false;
		}
		
		return isSingleCharStr ? -1 : str.length - 1;
	}
}