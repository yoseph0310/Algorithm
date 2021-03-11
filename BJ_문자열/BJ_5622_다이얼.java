package BJ_문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5622_다이얼 {
	public static void main(String[] args) throws Exception {
		int cnt = 0;
		int value;
		
		while(true) {
			value = System.in.read();
			
			if (value == '\n') {
				break;
			}
			
			if(value< 68) cnt += 3;
			else if(value< 71) cnt+=4;
			else if(value< 74) cnt+=5;
			else if(value< 77) cnt+=6;
			else if(value< 80) cnt+=7;
			else if(value< 84) cnt+=8;
			else if(value< 87) cnt+=9;
			else cnt += 10;
			
		}
		
		System.out.println(cnt);
	}
}
