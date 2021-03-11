package BJ_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_2747_피보나치수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int n1 = 0;
		int n2 = 0;
		int temp1 = 0;
		int temp2 = 0;
		
		for (int i = 0; i < N; i++) {
			if ( i==0 || i==1 ) {
				n1 = n2;
				n2 = 1;
			}
			else {
				temp1 = n1;
				temp2 = n2;
				n1 = temp2;
				n2 = temp1+temp2;
			}
		}
		System.out.println(n2);
	}

	
}
