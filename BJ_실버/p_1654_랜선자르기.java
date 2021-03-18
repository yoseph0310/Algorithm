package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_1654_랜선자르기 {
	
	static int K, N;
	static int [] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		long max = arr[K-1];
		long min = 1;
		long mid = 0;
		
		while( max >= min ) {
			mid = (max+min) / 2;
			
			long allCnt = 0;
			
			for (int i = 0; i < K; i++) {
				allCnt += arr[i]/mid;
			}
			
			if ( allCnt >= N) {
				min = mid + 1;
			} else if ( allCnt < N) {
				max = mid -1;
			}
		}
		
		System.out.println(max);
		
	}

}
