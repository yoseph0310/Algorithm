package BJ_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p_5904_Moo게임_S1_질문 {

	static char answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		moo(N);
		System.out.println(answer);
	}

	static void moo(int n) {
		
		int size = 3;
		int idx = 0;
		
		if(n==1) {
			answer='m';
		} else if ( n<=3 ) {
			answer='o';
		} else {
			while(size<n) {
				size = size*2+idx+4;
				idx++;
			}
			
			int front_back = (size-idx-3)/2;
			
			if(size - front_back + 1<= n) {
				moo(n - size + front_back);
			} else if ( n == front_back + 1) {
				answer = 'm';
			} else {
				answer = 'o';
			}
		}
		
	}
}
