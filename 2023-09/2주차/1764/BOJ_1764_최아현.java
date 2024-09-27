import java.io.*;
import java.util.*;

public class BOJ_1764_최아현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>(map.keySet());

        for(int i=0; i<N; i++){
        	String name1 = br.readLine();
            map.put(name1, 1);
        }
        for(int j=0; j<M; j++){
            String name2 = br.readLine();
            if(map.containsKey(name2)){
                list.add(name2);
            }   
        }
        Collections.sort(list);
        System.out.print(list.size() + "\n");   
        for(int k=0; k<list.size(); k++){
            System.out.print(list.get(k) + "\n");    
        } 
    }
}
