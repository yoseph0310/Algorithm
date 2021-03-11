package BJ_시간복잡도와기초지식연습문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2490_윷놀이 {
	
	static int [][]  yoot;
	static int cnt; // 0을 센다

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		yoot = new int[3][4];
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				yoot[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 3; i++) {
			cnt = 0;
			for (int j = 0; j < 4; j++) {
				if ( yoot[i][j] == 0) cnt++;
			}
			
			if ( cnt == 0 ) System.out.println("E");
			else if ( cnt == 1 ) System.out.println("A");
			else if ( cnt == 2 ) System.out.println("B");
			else if ( cnt == 3 ) System.out.println("C");
			else if ( cnt == 4 ) System.out.println("D");
			
		}
		
		
	}

}
