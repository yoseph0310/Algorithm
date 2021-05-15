package Programmers;

public class 카펫 {
	public int[] solution(int brown, int yellow) {

		int height = 0;
		int width = 0;
		for (height = 3; height <= (int) (brown + 4) / 2; height++) {
			width = ((brown + 4) / 2) - height;
			if (width < height) {
				break;
			}

			int yellowCnt = (width - 2) * (height - 2);
			if (yellow == yellowCnt) {
				break;
			}
		}
		int[] answer = new int[] { width, height };
		return answer;
	}
}
