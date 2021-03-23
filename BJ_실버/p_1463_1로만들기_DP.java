package BJ_실버;

import java.util.Arrays;
import java.util.Scanner;

public class p_1463_1로만들기_DP {
	
	static int memoi[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		memoi = new int[X+1];
		
		memoi[0] = 0;
		memoi[1] = 0;
		for (int i = 2; i <= X; i++) {
			memoi[i] = memoi[i-1] + 1;
			if ( i % 2 == 0) memoi[i] = Math.min(memoi[i], memoi[i/2] + 1);
			if ( i % 3 == 0) memoi[i] = Math.min(memoi[i], memoi[i/3] + 1);
		}
		
		System.out.println(memoi[X]);
	}
	
}
