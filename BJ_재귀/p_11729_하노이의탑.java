package BJ_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_11729_하노이의탑 {
	
	static StringBuilder sb = new StringBuilder();
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
//		sb.append((int)(Math.pow(2, N)-1)).append('\n');
		
		move(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	static void move(int board, int from, int temp, int to) {
		cnt++;
		
		if( board == 1) {
			sb.append(from+" "+ to +"\n");
			return;
		}
		
		move(board-1, from, to, temp);
		sb.append(from+" "+ to +"\n");
		move(board-1, temp, from, to);
		
	}

}
