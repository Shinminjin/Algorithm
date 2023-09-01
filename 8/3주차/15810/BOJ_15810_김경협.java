/**
 * BOJ 15810
 * 풍선 공장
 * 
 * 이분 탐색
 * 
 * endTime 설정 및 변수 타입 설정이 어려웠다.
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		
		int[] blowTime = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int maxBlowTime = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			blowTime[i] = Integer.parseInt(st.nextToken());
			maxBlowTime = Math.max(blowTime[i], maxBlowTime);
		}
		
		long startTime = 1;
		long endTime   = maxBlowTime * M;
		
		while (startTime < endTime) {
			long midTime = (startTime + endTime) / 2;
			long count = countBalloon(blowTime, midTime);
			
			if (count >= M) {
				endTime = midTime;
			} else {
				startTime = midTime + 1;
			}
		}
		
		System.out.println(startTime);
	}
	
	public static long countBalloon(int[] blowTime, long time) {
		long sum = 0;
		
		for (int i = 0; i < blowTime.length; i++) {
			sum += time / blowTime[i];
		}
		
		return sum;
	}

}
