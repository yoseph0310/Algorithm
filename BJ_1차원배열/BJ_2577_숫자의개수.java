package BJ_1차원배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2577_숫자의개수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int[] counts = new int[10];						// 0~9 까지의 숫자를 카운트할 배열 생성
		String input = String.valueOf(A * B * C);		// String 타입 input에 A*B*C(int) 값을 String으로 변환
		for (int i = 0; i < input.length(); i++) {
			counts[input.charAt(i) - '0']++;			// input의 길이만큼 input의 요소 하나씩을 count배열의 인덱스로 주고 1씩 증가
		}
		
		for (int i = 0; i < counts.length; i++) {		// count의 길이만큼 카운트 배열의 요소 출력
			System.out.println(counts[i]);
		}
		
	}

}
