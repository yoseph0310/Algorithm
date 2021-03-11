package BJ_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1992_쿼드트리_S1 {
	
	static int N;
	static int [][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		
//		print(map);
		
		divide(0,0,N);
		
		System.out.println(sb);
	}
	
	static boolean check(int r, int c, int size) {
		int start = map[r][c];
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if ( start != map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void divide(int r, int c, int size) {
		
		// 같은 숫자인지 체크
		if ( check(r,c,size)) {
			sb.append(map[r][c]);
		} else {
			sb.append("(");
			
			int newSize = size/2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					divide(r+newSize*i , c+newSize*j, newSize);
				}
			}
			sb.append(")");
		}
		
		
		
		
	}
	
	
	static void print(int[][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
