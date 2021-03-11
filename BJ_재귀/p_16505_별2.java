package BJ_재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p_16505_별2 {
	
	static int N, length;
	static char [][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		length = (int)Math.pow(2, N);
		map = new char[length][length];
		
		star(0,0,length);
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if ( j == length-i) break;
				if ( map[i][j] == '*' ) bw.write(map[i][j]);
				else bw.write(' ');
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
	
	static void star(int r, int c, int length) {
		
		if ( length == 1 ) {
			map[r][c] = '*';
			return;
		}
		
		int newLength = length/2;
		star(r,c,newLength);
		star(r,c+newLength,newLength);
		star(r+newLength,c,newLength);
		
		
	}

}
