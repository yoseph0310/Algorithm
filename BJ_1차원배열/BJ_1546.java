package BJ_1차원배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1546 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		double max = 0;
		double sum = 0;
		double arr[] = new double[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i]/max*100;
			sum+=arr[i];
		}
		System.out.println(sum/N);
	}

}
