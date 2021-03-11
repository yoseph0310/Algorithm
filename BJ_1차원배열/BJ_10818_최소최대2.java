package BJ_1차원배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10818_최소최대2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int res = 0;
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			res = Integer.parseInt(st.nextToken());
			min = Math.min(min, res);
			max = Math.max(max, res);
		}
		System.out.println(min+" "+max);
	}

}
