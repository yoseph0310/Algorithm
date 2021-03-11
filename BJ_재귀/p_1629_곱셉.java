package BJ_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1629_곱셉 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		
		System.out.println(run(a,b,c)%c);

	}
	
	static long run(long a, long b, long c ) {
		
		if ( b == 0 ) return 1;
		else if ( b == 1 ) return a;
		else if ( b % 2 == 0 ) {
			long n = run( a, b/2, c ) % c;
			return ( n * n ) % c;
		}
		else {
			long n = run( a, b/2, c ) % c;
			return ((( n * n ) % c ) * a ) % c; 
		}
		
		
	}
}
