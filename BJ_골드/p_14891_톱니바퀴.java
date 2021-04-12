package BJ_골드.p_14891_톱니바퀴;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14891_톱니바퀴 {
	
	static int Wheel[][] = new int[4][8];
	static int isValid[];
	static int K, swNum, dir, sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 4; i++) {
			String [] str = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				Wheel[i][j] = Integer.parseInt(str[j]);
			}
		}
//		print(sawWheel);
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			isValid = new int[4];
			
			swNum = Integer.parseInt(st.nextToken()) - 1;
			dir = Integer.parseInt(st.nextToken());
			
			 check(swNum,dir);
			 turn(isValid);
		}
		
		System.out.println(calc());
		
	}
	static int calc() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int num = Wheel[i][0];
			
			if ( num == 1) {
				sum += Math.pow(2, i);
			}
		}
		
		return sum;
	}
	
	static void check(int swNum, int dir) {
		isValid[swNum] = dir;
		
		int prev = swNum - 1;
		int next = swNum + 1;
		
		if ( prev >= 0 && isValid[prev] ==  0 ) {
			if ( Wheel[prev][2] != Wheel[swNum][6]) {
				check(prev, dir * -1);
			}
		}
		
		if (next <= 3 && isValid[next] == 0) {
			if(Wheel[next][6] != Wheel[swNum][2]) {
				check(next,dir * -1);
			}
		}
		
	}
	
	static void turn(int[] isValid) {
		for (int i = 0; i < 4; i++) {
			if ( isValid[i] != 0) {
				int [] temp = new int[8];
				
				int idx;
				for (int j = 0; j < 8; j++) {
					idx = j + isValid[i];
					
					if ( idx == -1) {
						idx = 7;
					} else if (idx == 8) {
						idx = 0;
					}
					
					temp[idx] = Wheel[i][j];
				}
				
				Wheel[i] = temp;
				
			}
		}
		
	}

	static void print(int[][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}

// 8개의 톱니를 가진 톱니바퀴 4개 - 1, 2, 3, 4
// N극 S극 존재
// 맞닿은 톱니의 극이 다르면 B는 A 회전방향과 반대, 극이 같으면 회전하지 않는다.
