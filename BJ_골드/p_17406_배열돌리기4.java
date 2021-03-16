package BJ_골드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_17406_배열돌리기4 {
	
	static int N, M, K;
	static int [][] map;
	static boolean [] visited;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		
		// 배열 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		print(map);
		// 회전 연산 정보 입력
		
		int [][] operation = new int[K][];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			operation[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		
		
		System.out.println(solve(operation));
		
		
	} // main
	
	static int solve(int[][] operation) {
		visited = new boolean[K];
		
		dfs( 0, operation, map);
		
		return ans;
	}

	
	
	static void dfs(int cnt, int[][] operation, int[][] tempMap) {
		if (cnt == K) {
			ans = Math.min(ans, getMinRowSum(tempMap));
			return;
		}
		
		for (int i = 0; i < operation.length; i++) {
			if ( !visited[i] ) {
				int [][] copy = arrayCopy(tempMap);
				
				int [] op = operation[i];
				int r = op[0], c = op[1], s = op[2];
				
				int sr = r-s, er = r+s;
				int sc = c-s, ec = c+s;
				
				rotate(sr, sc, er, ec, copy);
				
				visited[i] = true;
				dfs(cnt+1, operation, copy);
				visited[i] = false;
			}
		}
		
	}
	
	// 각 행의 최솟값 구하는 함수
	static int getMinRowSum(int [][] arr) {
		int ret = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <=M; j++) {
				cnt+=arr[i][j];
			}
			ret = Math.min(ret, cnt);
		}
		return ret;
	}

	// 회전 시키는 함수
	static void rotate(int sr, int sc, int er, int ec, int[][] tempMap) {
		int depth = 0;
		
		while( true ) {
			int nsr = sr + depth, ner = er - depth;
			int nsc = sc + depth, nec = ec - depth;
			if ( nsr >= ner || nsc >= nec ) break;
			
			int preVal = tempMap[nsr - 1][nsc];
			 
            for (int c = nsc; c <= nec; c++) {
                int temp = tempMap[nsr][c];
                tempMap[nsr][c] = preVal;
                preVal = temp;
            }
 
            for (int r = nsr + 1; r <= ner; r++) {
                int temp = tempMap[r][nec];
                tempMap[r][nec] = preVal;
                preVal = temp;
            }
 
            for (int c = nec - 1; c >= nsc; c--) {
                int temp = tempMap[ner][c];
                tempMap[ner][c] = preVal;
                preVal = temp;
            }
 
            for (int r = ner -1; r >= nsr; r--) {
                int temp = tempMap[r][nsc];
                tempMap[r][nsc] = preVal;
                preVal = temp;
            }
            depth++;
		}
	}
	
	// 배열복사하는 함수 
	static int[][] arrayCopy(int [][] arr){
		int [][] c_map = new int[arr.length][];
		
		for (int i = 0; i < arr.length; i++) {
			c_map[i] = arr[i].clone();
		}
		
		return c_map;
	}

	static void print(int[][]map) {
		for (int i = 1; i <= map.length; i++) {
			for (int j = 1; j <= map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}// class
// N*M 크기의 배열 A
// 배열 A의 값 : 각 행에 있는 모든 수의 합중 최솟값.

// 회전 연산

// 
