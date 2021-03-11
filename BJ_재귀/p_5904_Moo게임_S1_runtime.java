package BJ_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p_5904_Moo게임_S1_runtime {

	static StringBuilder sb = new StringBuilder();
	static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		moo(N);
		System.out.println(list);
		System.out.println(list.get(N-1));
	}

	static void moo(int n) {
		
		if ( n == 0 ) {
			list.add("m");
			for (int i = 0; i < n+2; i++) {
				list.add("o");
			}
			return;
		}
		
		moo(n-1);
		list.add("m");
		for (int i = 0; i < n+2; i++) {
			list.add("o");
		}
		moo(n-1);
		
	}
}
