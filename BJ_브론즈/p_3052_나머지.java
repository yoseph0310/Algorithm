package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class p_3052_나머지 {
	
	static boolean [] arr = new boolean[42];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			arr[Integer.parseInt(br.readLine()) % 42] = true;
		}
		
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if ( arr[i] ) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
//public class p_3052_나머지 {
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		HashSet<Integer> hs = new HashSet<>();
//		
//		for (int i = 0; i < 10; i++) {
//			hs.add(Integer.parseInt(br.readLine()) % 42);
//		}
//		
//		System.out.println(hs.size());
//		
//	}
//	
//}
