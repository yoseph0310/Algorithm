package SW_D4.p_4340_파이프연결;

import java.util.Scanner;

public class p_4340_파이프연결 {
	
	static int N, min;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map = new int[52][52];
	static boolean[][] visit = new boolean[52][52];

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tnum = input.nextInt();
		map[1][0] = 1;
		for (int t = 1; t <= tnum; t++) {
			N = input.nextInt();
			map[N][N + 1] = 1;
			min = 100000;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = input.nextInt();
				}
			}
			bakcTracking(N, N + 1, N, N, 1);
			System.out.println("#" + t + " " + (min - 1));
		}
	}

	private static void bakcTracking(int pX, int pY, int X, int Y, int l) {
		int nX, nY;
		if (X == 1 && Y == 0) {
			if (min > l)
				min = l;
			return;
		}
		if (map[X][Y] < 3) {
			if (Y == pY) {
				if (X == pX - 1)
					nX = X - 1;
				else
					nX = X + 1;
				nY = Y;
			} else {
				if (pY == Y + 1)
					nY = Y - 1;
				else
					nY = Y + 1;
				nX = X;
			}
			if (nX != -1) {
				if (map[nX][nY] != 0 && !visit[nX][nY] && (nX + nY + l) < min) {
					visit[nX][nY] = true;
					bakcTracking(X, Y, nX, nY, l + 1);
					visit[nX][nY] = false;
				}
			}
		} else {
			if (pX == X) {
				nX = X - 1;
				nY = Y;
				if (map[nX][nY] != 0 && !visit[nX][nY] && (nX + nY + l) < min) {
					visit[nX][nY] = true;
					bakcTracking(X, Y, nX, nY, l + 1);
					visit[nX][nY] = false;
				}
				nX = X + 1;
				nY = Y;
				if (map[nX][nY] != 0 && !visit[nX][nY] && (nX + nY + l) < min) {
					visit[nX][nY] = true;
					bakcTracking(X, Y, nX, nY, l + 1);
					visit[nX][nY] = false;
				}
			} else {
				nY = Y - 1;
				nX = X;
				if (map[nX][nY] != 0 && !visit[nX][nY] && (nX + nY + l) < min) {
					visit[nX][nY] = true;
					bakcTracking(X, Y, nX, nY, l + 1);
					visit[nX][nY] = false;
				}
				nY = Y + 1;
				nX = X;
				if (map[nX][nY] != 0 && !visit[nX][nY] && (nX + nY + l) < min) {
					visit[nX][nY] = true;
					bakcTracking(X, Y, nX, nY, l + 1);
					visit[nX][nY] = false;
				}
			}
		}
	}
}
