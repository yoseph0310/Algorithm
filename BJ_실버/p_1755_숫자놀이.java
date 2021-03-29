package BJ_실버.p_1755_숫자놀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class p_1755_숫자놀이 {

	static int M, N;
	static List<Number> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());		// M 이상
		N = Integer.parseInt(st.nextToken());		// N 이하의 정수
		
		// M 이상 N이하의 정수를 입력 받는다.
		for (int i = M; i <= N; i++) {
			list.add(new Number(i, numbering(i)));	// 숫자와 string으로 변환한 숫자 list에 add
		}
		
		// 사전순 정렬
		Collections.sort(list, new Comparator<Number>() {

			@Override
			public int compare(Number o1, Number o2) {
				
				return o1.str.compareTo(o2.str);		// 사전순으로 정렬
			}
			
		});
		
		int cnt = 0;		// 10개 인지 셀 cnt 변수
		for (Number n : list) {
			System.out.print(n.num+" ");		// 출력할때마다		
			cnt++;								// cnt를 1씩 증가
			if ( cnt == 10) {					// cnt 10이 되면
				cnt = 0;						// 0으로 초기화 하고
				System.out.println();			// 문자열 개행
			}
		}
		
		
	} // main
	
	static String numbering(int num) {
		
		String s = "";
		
		if ( num >= 10) {			// NUM 은 99 이하의 숫자이므로 10이상의 수만 체크했다.
			int ten = num/10;		// num의 10의자리
			int one = num%10;		// num의 1의 자리
			String ten_s = transform(ten);
			String one_s = transform(one);
			
			s = ten_s +" "+one_s;
			
			return s;
		}
		
		else {
			s = transform(num);
		}
		
		return s;
	}
	
	// 정수를 입력받아 그 정수에 맞는 string을 저장
	static String transform(int num) {
		String s = "";
		if ( num == 1) {
			s = "one";
		} else if ( num == 2) {
			s = "two";				
		} else if ( num == 3) {
			s = "three";				
		} else if ( num == 4) {
			s = "four";				
		} else if ( num == 5) {
			s = "five";				
		} else if ( num == 6) {
			s = "six";				
		} else if ( num == 7) {
			s = "seven";				
		} else if ( num == 8) {
			s = "eight";				
		} else if ( num == 9) {
			s = "nine";				
		} else if ( num == 0) {
			s = "zero";				
		} 
		return s;
	}

	static class Number{
		int num;
		String str;
		
		public Number ( int num, String str) {
			this.num = num;
			this.str = str;
		}
	}

}
// 
