import java.util.*;
import java.io.*;

class Solution {
    Map <String, Integer> Jangbgn = new HashMap<String, Integer>();
    int total=0;
    public void makeHmap(String[] want, int[] number){
        Jangbgn.clear();
        total=0;
        for(int i=0; i<want.length; i++){
            Jangbgn.put(want[i], number[i]);
            total += number[i];
        }
    }
    public int solution(String[] want, int[] number, String[] discount) {
        int answer=0;
        int count=0;
        int cnt=0;
    
        while(cnt<discount.length){
            makeHmap(want, number);
            count=0;
            for(int j=answer; j<discount.length; j++){
                if(!(Jangbgn.get(discount[j])==null || Jangbgn.get(discount[j])==0)){
                    count++;
                    Jangbgn.put(discount[j], Jangbgn.get(discount[j]) -1);
                    if(count==total || j==discount.length-1){
                        cnt=discount.length;
                    }
                }
                else{
                    cnt++;
                    break;
                }
            }
            answer++;
        }
        if(count==total){
            return answer;
        }
        else{
            return 0;
        }
    }
}
