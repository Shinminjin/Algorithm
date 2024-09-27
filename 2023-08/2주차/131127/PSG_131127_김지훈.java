import java.util.*; 
// 할인 행사
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int cnt = 0;

        // 필요한 물건 list
        List<String> wantList = new ArrayList<String>();
        
        for (int i=0; i<number.length; i++) {
            for (int j=0; j<number[i]; j++) {
                wantList.add(want[i]);
            }
        }
        
        Collections.sort(wantList);
        
        List<String> discountList = Arrays.asList(discount);
        
        while (cnt<discountList.size()) {
        
            int endindex = (cnt+10) >= discountList.size() ? discountList.size() : (cnt+10);
            
            // 특정 날짜 부터 10일간 할인 제품 List
            List<String> subDiscountList = new ArrayList<>(discountList.subList(cnt, endindex));
            
            Collections.sort(subDiscountList);
            
            // 필요한 물건과 할인제품이 일치하면, answer++
            if (Arrays.equals(subDiscountList.toArray(), wantList.toArray())) {
              answer++;
            }
            cnt ++;
        }
        
        return answer;
    }
}