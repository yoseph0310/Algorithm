package BJ_재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p_2477_별찍기10_S1_2 {
	
	static int N;
	static char[][]map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		star(0,0,N,false);
		
		for (int i = 0; i < N; i++) {
			bw.write(map[i]);
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}
	
	static void star(int r, int c, int N, boolean blank) {
		
		// 공백
		if ( blank ) {
			for (int i = r; i < r+N; i++) {
				for (int j = c; j < c+N; j++) {
					map[i][j] = ' ';
				}
			}
			return;
		}
	
		// 더 이상 쪼갤 수 없을 때
		if ( N == 1 ) {
			map[r][c] = '*';
			return;
		}
		
		// 반복 구간
		
		int size = N/3;
		int count = 0;
		for (int i = r; i < r+N; i+=size) {
			for (int j = c; j < c+N; j+=size) {
				count++;
				if ( count == 5 ) {
					star(i,j, size, true);
				} else {
					star(i,j, size, false);
				}
			}
		}
		
	}
	
}
