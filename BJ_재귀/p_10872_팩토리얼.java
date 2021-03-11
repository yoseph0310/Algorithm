package BJ_재귀;

import java.util.Scanner;

public class p_10872_팩토리얼 {
	
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		System.out.println(fibo(N));
	}
	
	static int fibo(int n) {
		if ( n <= 1 ) {
			return 1;
		}
		
		return n*fibo(n-1);
	}

}
