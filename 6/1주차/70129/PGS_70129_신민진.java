import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int cnt = 0; // 변환 횟수
        int zeroCnt = 0; // 제거된 0 개수
        
        while(!s.equals("1")) {
            int length = s.length(); // 이진 변환 전, 문자열길이
            s = s.replace("0", ""); // 0 제거
            zeroCnt += length - s.length();
            
            // 이진변환 과정
            List<Integer> binaryTmp = new ArrayList<>(); // 나머지저장(임시)
            length = s.length(); // 1 개수
            while(length > 1) {
                binaryTmp.add(length % 2);
                length /= 2;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append("1");
            for (int i=binaryTmp.size()-1; i>=0; i--) {
                sb.append(binaryTmp.get(i));
            }
            s = sb.toString();

            cnt++; // 변환횟수 증가
        }
        
        answer[0] = cnt;
        answer[1] = zeroCnt;
        
        return answer;
    }
}