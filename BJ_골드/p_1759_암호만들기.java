package BJ_골드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_1759_암호만들기_과제 {
	
	static int L, C;	
	static boolean [] visit;
	static String [] pass;
	static String [] total;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());		// 암호 구성 고를 개수 (target)
		C = Integer.parseInt(st.nextToken());		// 문자의 종류 개수 (total)
		
		visit = new boolean[C];
		
		pass = new String[L];
		total = new String[C];
		
		total = br.readLine().split(" ");
		
		Arrays.sort(total);
//		for (int i = 0; i < C; i++) {
//			System.out.print(total[i]);
//		}
		
		dfs(0);
		System.out.println(sb.toString());
		
	}
	
	static void dfs(int cnt) {
		
		if ( cnt == L ) {
			if ( !check(pass) ) {
				return;
			} else {
				for (int i = 0; i < L; i++) {
					sb.append(pass[i]);
				}
				sb.append("\n");
				return;
			}
		}
		
		
		for (int i = 0; i < C; i++) {
			if ( cnt == 0 || !visit[i] && pass[cnt-1].compareTo(total[i]) < 0) {		// 방문하지 않았으면 정렬이 되어있는지 체크하고 다음 탐색
				visit[i] = true;
				pass[cnt] = total[i];
				dfs(cnt+1);
				visit[i] = false;
			}
		}
	}

	static boolean check(String[] str) {
		
		int mo = 0;
		int ja = 0;
		
		for (String s : str) {
			if ( s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
				mo++;
			} else {
				ja++;
			}
		}
		
		if ( mo >= 1 && ja >= 2) return true;
		
		return false;
	}

}