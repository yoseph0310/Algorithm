package 모의SW_A형_역량테스트대비.p_4014;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_4014_활주로건설 {
	
	static int T, N, X, ans;
	static int map[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());	// 지도 한변의 크기
			X = Integer.parseInt(st.nextToken());	// 경사로 길이
			
			map = new int[N][N];
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			print(map);
			// 행 활주로 건설
			for (int r = 0; r < N; r++) {
				if ( isPossible(r, true)) {
					ans++;
				} else {
					if ( canConstruct(r, true)) {
						ans++;
					}
				}
			}
			
			// 열 활주로 건설
			for (int c = 0; c < N; c++) {
				if ( isPossible(c, false)) {
					ans++;
				} else {
					if ( canConstruct(c, false)) {
						ans++;
					}
				}				
			}
			
			System.out.println("#"+t+" "+ans);
		}
		
	}
	//
	static boolean canConstruct(int idx,boolean isRow) {
		
		boolean visited[] = new boolean[N];
		int cnt = 0;	// 건설 카운트
		int before = -1; // 이전 지대 높이
		
		if ( isRow) {
			before = map[idx][0];
			
			for (int c = 0; c < N; c++) {
				int cur = map[idx][c];
				
				if(cur == before) {
					cnt++;
				} else {
					if ( cur == before + 1) {		// 지대가 높아짐
						
						if( cnt >= X) {				// 경사로 설치
							for (int i = c-X; i < c; i++) {
								if (visited[i]) return false;
								visited[i] = true;
							}
							cnt = 1;
						} else { 	// 길이가 부족하여 경사로 건설 불가
							return false;
						}
						
					} else if(cur == before - 1) { 	// 지대가 낮아짐
						
						if ( c + X -1 < N ) {		// 경사로 설치
							for (int i = c; i < c+X; i++) {
								if (visited[i] || map[idx][i] != cur ) return false;
								visited[i] = true;
							}
							cnt = 0;
							c = c + X - 1;
						} else {
							return false; // 길이가 부족하여 경사로 건설 불가
						}
						
					} else {
						return false;
					}
					before = cur;
				}
			}
			
		} else {
			before = map[0][idx];
			
			for (int r = 0; r < N; r++) {
				int cur = map[r][idx];
				
				if(cur == before) {
					cnt++;
				} else {
					if ( cur == before + 1) {		// 지대가 높아짐
						
						if( cnt >= X) {				// 경사로 설치
							for (int i = r-X; i < r; i++) {
								if (visited[i]) return false;
								visited[i] = true;
							}
							cnt = 1;
						} else { 	// 길이가 부족하여 경사로 건설 불가
							return false;
						}
						
					} else if(cur == before - 1) { 	// 지대가 낮아짐
						
						if ( r + X -1 < N ) {		// 경사로 설치
							for (int i = r; i < r+X; i++) {
								if (visited[i] || map[i][idx] != cur ) return false;
								visited[i] = true;
							}
							cnt = 0;
							r = r + X - 1;
						} else {
							return false; // 길이가 부족하여 경사로 건설 불가
						}
						
					} else {
						return false;
					}
					before = cur;
				}
			}
			
		}
		return true;
	}
	
	static boolean isPossible(int idx, boolean isRow) {
		int start = -1;
		
		if ( isRow ) {
			start = map[idx][0];
			for (int c = 0; c < N; c++) {
				if(map[idx][c] != start) return false;
			}
		} else {
			start = map[0][idx];
			for (int r = 0; r < N; r++) {
				if(map[r][idx] != start) return false;
			}
		}
		return true;
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
// 모든 행과 열에 대해 수행
	// 현재 상태에서 활주로 건설 가능?
		// 가능하면 건설 cnt ++
		// 가능하지 않다면 경사로 설치해서 활주로 건설이 가능한지 확인

// 지대가 높,낮아지는 경우
