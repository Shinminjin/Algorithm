package algorithm;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.*;

public class BOJ_1874_황배근 {
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder res = new StringBuilder(); // 결과물 저장하는 거고
        
        
        int N = Integer.parseInt(bf.readLine());
        
        int[] stack = new int[N];
        
        int idx = 0;
        int start = 0; 
        
        while (N-- > 0) {
            
            int num = Integer.parseInt(bf.readLine());
            
            if (num > start) {
                for (int i = start + 1; i <= num; i++) {
                    stack[idx] = i;
                    idx++;
                    res.append("+").append("\n");
                }
                start = num;
            }
            else if (stack[idx - 1] != num) {
                System.out.println("NO");
                return;
            }
            
            idx--;
            res.append("-").append("\n");
        }
        
        System.out.println(res);
        
    }
}