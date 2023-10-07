import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_5397_김지훈 {
    static LinkedList<Character> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            result = new LinkedList<>(); // ArrayList 로 하면 시간초과...
            ListIterator<Character> list = result.listIterator();
            String str = br.readLine();
            
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                switch(c) {
                    case '<' :
                        if(list.hasPrevious()) {
                            list.previous();
                        }
                        break;
                    case '>' :
                        if(list.hasNext()) {
                            list.next();
                        }
                        break;
                    case '-' :
                        if(list.hasPrevious()) {
                            list.previous();
                            list.remove();
                        }
                        break;
                    default : 
                        list.add(c);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(char s : result) {
                sb.append(s);
            }
            System.out.println(sb.toString());
        }
    }
}
