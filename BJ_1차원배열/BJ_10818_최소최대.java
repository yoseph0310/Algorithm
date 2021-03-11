package BJ_1차원배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10818_최소최대 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int max = -1000000, min = 1000000;
		int [] arr = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			if ( max < arr[i] ) max = arr[i];
			if ( min > arr[i] ) min = arr[i];
		}
		System.out.println(min+" "+max);
	}

}
