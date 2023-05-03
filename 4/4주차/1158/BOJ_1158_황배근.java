package algorithm;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ_1158_황배근 {
	public static void main(String[] args) throws Exception{
		
		// 입,출력 및 큐
		
		System.setIn(new FileInputStream("src/algorithm/input.txt"));
        Scanner sc = new Scanner(System.in);
        
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        
        Queue<Integer> yosep = new LinkedList<>();
        
        for (int i = 1; i < N + 1; i++) {
        	yosep.add(i);
        }
        
        System.out.print('<');
        while(yosep.size() > 1) {
        	for (int j = 0; j < M - 1; j++) {
        		yosep.add(yosep.poll());
        	}
        	System.out.print(yosep.poll() + ", ");
        }
        System.out.print(yosep.poll());
        System.out.print('>');
        sc.close();
	}
}
