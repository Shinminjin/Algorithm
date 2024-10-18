import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    
        int n = in.nextInt();
        String str = Integer.toString(n);
        int[] arr = {0,0,0,0,0,0,0,0,0,0};
    
        for(int i=0;i<str.length(); i++){
            int num = str.charAt(i)-'0';
            if(num==6 | num==9){
                if(arr[6]==arr[9]){
                    arr[num]+=1;
                }
                else if(arr[6]>arr[9]){
                    arr[9]+=1;
                }
                else arr[6]+=1;
            }
            else arr[num] +=1;
        }
        int max = 0;
        for(int j=0;j<10; j++){
            max = max < arr[j] ? arr[j] : max;
        }
        System.out.println(max);
        in.close();
    }
}
