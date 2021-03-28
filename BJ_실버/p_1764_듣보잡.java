package BJ_실버.p_1764_듣보잡;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p_1764_듣보잡 {
	
	static int N, M;
	static HashSet<String> hs = new HashSet<>();
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			hs.add(br.readLine());
		}
		
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if ( hs.contains(s)) {
				cnt++;
				list.add(s);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for (String str : list) {
			System.out.println(str);
		}
		
		
	}
	
	static void print(String [] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		System.out.println();
	}

}

