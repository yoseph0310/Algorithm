package BJ_시간복잡도와기초지식연습문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_10093_숫자 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long start_num = Long.parseLong(st.nextToken());
		long end_num = Long.parseLong(st.nextToken());
		
		if ( start_num > end_num) {
			System.out.println(start_num-end_num-1);
			for (long i = end_num+1; i < start_num; i++) {
				System.out.print(i+" ");
			}
		}
		
		if ( end_num > start_num ) {
			System.out.println(end_num - start_num - 1);
			for (long i = start_num+1; i < end_num; i++) {
				System.out.print(i+" ");
			}
		}
		if ( start_num==end_num) {
			System.out.println(0);
		}
		
		
		
	}

}
