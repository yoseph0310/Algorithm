package BJ_재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p_2448_별찍기11_G4 {
	
	static char[][]map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		map = new char[N][2*N-1];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2*N-1; j++) {
				map[i][j] = ' ';
			}
		}
		
		star(0,N-1,N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2*N-1; j++) {
				bw.append(map[i][j]);
			}
			bw.append('\n');
		}
		
		bw.flush();
		bw.close();
	}
	
	static void star(int r, int c, int n ){
		
		if ( n == 3 ) {
			map[r][c] = '*';
			map[r+1][c-1] = map[r+1][c+1] = '*';
			map[r+2][c-2] = map[r+2][c-1] = map[r+2][c] = map[r+2][c+1] = map[r+2][c+2] = '*';
			return;
		}
		
		star(r, c, n / 2);
		star(r + n / 2, c - n / 2, n / 2);
		star(r + n / 2, c + n / 2, n / 2);
	}
	
}
