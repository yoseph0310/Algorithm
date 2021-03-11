package BJ_문자열;

public class delete {

	public static void main(String[] args) {
		String s = "aaaa";
		
		for (int i = 0; i < s.length(); i++) {
			int n = s.charAt(i);
			
			System.out.println(n-'a');
		}

	}

}
