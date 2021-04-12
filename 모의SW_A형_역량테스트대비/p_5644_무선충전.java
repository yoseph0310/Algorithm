package 모의SW_A형_역량테스트대비.p_5644;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_5644_무선충전 {
	
	static int M, A;
	
	static int dx[] = {0,-1,0,1,0};
	static int dy[] = {0,0,1,0,-1};
	
	static int userA[];
	static int userB[];
	
	static ArrayList<AP> aplist;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());	// 총 이동 시간 
			A = Integer.parseInt(st.nextToken());	// BC의 개수 
			
			userA = new int[M];
			userB = new int[M];
			
			// 사용자A의 이동
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				userA[i] = Integer.parseInt(st.nextToken());
			}
			// 사용자B의 이동
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				userB[i] = Integer.parseInt(st.nextToken());
			}
			
			// BC의 정보 ArrayList에 저장
			aplist = new ArrayList<>();
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				aplist.add(new AP(x,y,c,p));
			}
			
			int ans = move();
			System.out.println("#"+t+" "+ans);
		}
		
	} // main
	
	static int move() {
		int x1 = 1;
		int y1 = 1;
		int x2 = 10;
		int y2 = 10;
		
		int sum = getMax(x1, y1, x2, y2);
		
		for (int i = 0; i < M; i++) {
			x1 += dx[userA[i]];
			y1 += dy[userA[i]];
			x2 += dx[userB[i]];
			y2 += dy[userB[i]];
			sum += getMax(x1,y1,x2,y2);
		}
		return sum;
	}
	
	
	
	static int getMax(int x1, int y1, int x2, int y2) {
		int[][] amount = new int[2][A];
		//2차원 배열에 사용자A(0)와 사용자B(1)의 BC별로 충전가능한 값을 저장해준다.
        
        //사용자A의 충전 가능한 BC의 p값
		for(int j=0; j<A; j++) {
				amount[0][j] = check(x1,y1,j);
		}
		
        //사용자B의 충전 가능한 BC의 p값
		for(int j=0; j<A; j++) {
			amount[1][j] = check(x2,y2,j);
			
		}
		
        //사용자 A와 사용자 B의 충전량의 합중 최댓값을 구해준다.
		int max = 0;
		for(int i=0; i<A; i++) {
			for(int j=0; j<A; j++) {
				int sum = amount[0][i]+amount[1][j];
                
                 // 같은 BC를 이용하는 경우 값을 반으로 나눠줘야한다.
                 // 주의할 점은 한 쪽은 아예 값이 0일수도 있으므로(해당 BC를 이용할 수 없는 위치) 정확히 둘다 같이 이용하고 있는 경우에만 나누어주어야한다.
				if(i == j && amount[0][i] == amount[1][j])
					sum /= 2;
				if(sum > max) max = sum;
			}
		}

		return max;
	}

	
	static int check(int x, int y, int apnum) {

		int a = Math.abs(x-aplist.get(apnum).x);
		int b = Math.abs(y-aplist.get(apnum).y);
		int dist = a+b;
        
        //해당 BC에 포함되는 경우에 p값을 리턴
		if(dist <= aplist.get(apnum).c)
			return aplist.get(apnum).p;
		else
			return 0;
	}

	static class AP{
		int x, y, c, p;
		
		public AP(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

}
