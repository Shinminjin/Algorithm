import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    
        int abc = in.nextInt() * in.nextInt() * in.nextInt();
        String str = Integer.toString(abc);
        int[] arr = {0,0,0,0,0,0,0,0,0,0};
    
        for(int i=0;i<str.length(); i++){
            int num = str.charAt(i) - '0';
            arr[num] += 1;
        }
        for(int j=0;j<10; j++){
            System.out.println(arr[j]);
        }
        in.close();
    }
}
