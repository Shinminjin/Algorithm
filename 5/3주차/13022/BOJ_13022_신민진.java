import java.io.*;

public class BOJ_13022_신민진 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String checkStr = br.readLine();
        char[] arrayStr = checkStr.toCharArray(); // 체크 편하게

        int wolf = 1; // 단계 Flag
        int cntFlag = 0; // w 개수
        int checkCnt = 0; // o,l,f 개수
        Boolean result = false; // 최종결과

        for (int i = 0; i < arrayStr.length; i++) {
            if (wolf == 1 && arrayStr[i] == 'w' && i < arrayStr.length-1) {
                if (arrayStr[i+1] == 'w') { cntFlag ++; } 
                else if (arrayStr[i+1] == 'o') { cntFlag ++; wolf = 2; } 
                else { result = false; break; }
            }
            else if (wolf == 2 && arrayStr[i] == 'o' && i < arrayStr.length-1) {
                if (arrayStr[i+1] == 'o') { checkCnt++; } 
                else if (arrayStr[i+1] == 'l') {
                    checkCnt++;
                    if (cntFlag != checkCnt) { result = false; break; }
                    wolf = 3;
                    checkCnt = 0;
                }
                else { result = false; break; }
            }
            else if (wolf == 3 && arrayStr[i] == 'l' && i < arrayStr.length-1) {
                if (arrayStr[i+1] == 'l') { checkCnt++; } 
                else if (arrayStr[i+1] == 'f') {
                    checkCnt++;
                    if (cntFlag != checkCnt) { result = false; break; }
                    wolf=4;
                    checkCnt = 0;
                } 
                else { result = false; break; }
            }
            else if (wolf == 4 && arrayStr[i] == 'f') {
                if (i == arrayStr.length - 1) {
                    checkCnt++;
                    if (cntFlag == checkCnt) { result = true; } // 정답인 케이스
                }
                else if (arrayStr[i+1] == 'f' && i < arrayStr.length-1) { checkCnt++; } 
                else if (arrayStr[i+1] == 'w' && i < arrayStr.length-1) {
                    checkCnt++;
                    if (cntFlag != checkCnt) { result = false; break; }
                    wolf=1;
                    checkCnt=0;
                    cntFlag = 0;
                }
                else { result = false; break;}
            }
            else { result = false; break; }
        }

        if (result) { System.out.println("1"); } 
        else { System.out.println("0"); }
    }
}