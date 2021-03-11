package BJ_시간복잡도와기초지식연습문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2480_주사위세개 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[3];
		
		int temp = 0;
		
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if ( arr[0] == arr[1] && arr[1] == arr[2] ) {
			System.out.print(10000+arr[0]*1000);
		} else if ( arr[0] == arr[1] ) {
			System.out.print(1000+arr[1]*100);
		} else if ( arr[1] == arr[2] ) {
			System.out.print(1000+arr[1]*100);
		} else if ( arr[0] == arr[2] ) {
			System.out.print(1000+arr[0]*100);
		} else {
			System.out.print(Math.max(Math.max(arr[0], arr[1]), arr[2] ) * 100);
		}
		
		
		
	}

}
