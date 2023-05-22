import java.io.*;

public class BOJ_15927_신민진 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int strLen = str.length(); // 문자열 길이
        int splitInt = strLen/2; // 문자열 반나누기
        char[] arrayStr = str.toCharArray(); // 체크편하게
        Boolean isPalin = true; // 팰린드롬 여부

        for (int i=0; i<splitInt; i++) {
            // 팰린드롬 체크
            if (arrayStr[i] != arrayStr[strLen-1-i]) {
                isPalin = false;
                break;
            }
        }

        if (!isPalin) {
            // 팰린드롬 아니면
            System.out.println(strLen);
        } else {
            // 팰린드롬 일 때, 모두 같은문자인지 체크
            if (strLen - (strLen - str.replace(String.valueOf(arrayStr[0]), "").length()) == 0) {
                System.out.println(-1);
            } else {
                System.out.println(strLen - 1);
            }
        }

    }
}
