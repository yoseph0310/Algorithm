package SW_D4.p_8382_방향전환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_8382_방향전환 {
	
	static int T, min, x1, y1, x2, y2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
					
			// 가로이동 세로이동 구분
			move(true); // 세로
			move(false);// 가로
			System.out.println("#"+t+" "+min);
		}

	}
	
	static void move(boolean flag) {
		
		int dx = x1, dy = y1, cnt = 0;
		
		while(true) {
			if ( dx == x2 && dy == y2) {
				if ( min > cnt ) min = cnt;
				break;
			}
			
			if (flag) {
				if ( dy > y2 ) dy--;
				else dy++;
				flag = false;
			}
			else {
				if ( dx > x2) dx--;
				else dx++;
				flag = true;
			}
			cnt++;
		}
		
	}
	
	

}
