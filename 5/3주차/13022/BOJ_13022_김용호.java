package boj13022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	// ���� : ���ĺ� ������ üũ�� ��� wolf ���� ��� �ʿ�
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String words = br.readLine();
		
		int wCnt = 0;
		int oCnt = 0;
		int lCnt = 0;
		int fCnt = 0;

		
		int len = words.length();
		int i = 0;
		
		// ���ĺ� ���� üũ
		while(i<len) {
			if (words.charAt(i)=='w') {
				wCnt++;
			} else if(words.charAt(i)=='o') {
				oCnt++;
			} else if(words.charAt(i)=='l') {
				lCnt++;
			} else if(words.charAt(i)=='f') {
				fCnt++;
			}
			i++;
		}
		
		
		int result;
		
		result = ((wCnt==oCnt)&&(lCnt==fCnt)&&(wCnt==lCnt)) ? 1:0;
		
		System.out.println(result);
	}

}
