package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_2999_비밀이메일2 {

	static int N, R, C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char [] arr = br.readLine().toCharArray();
		
		N = arr.length;
		
		for (int i = 1; i <= N; i++) {
			if ( N % i == 0 && i <= N/i) {
				 R = i;
				 C = N/i;
			}
		}
		
		char [][] map = new char[R][C];
		int idx = 0;
		
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				map[j][i] = arr[idx++];
			}
		}
		
//		print(map);
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
		}
//		System.out.println(R+" "+C);
	}
	
	public static void print(char[][]map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
