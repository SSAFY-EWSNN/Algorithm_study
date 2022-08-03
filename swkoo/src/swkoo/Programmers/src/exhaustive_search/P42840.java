package exhaustive_search;

class P42840 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/42480
	// 모의고사
	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };
		
		for (int i : solution(answers)) {
			System.out.printf("%d ", i);
		}

	}

	static int[] solution(int[] answers) {
		int[] answer = new int[3];
		int[] score = new int[3];

		int winner = 0;

		int pt1[] = { 1, 2, 3, 4, 5 };
		int pt2[] = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int pt3[] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int p1 = 0;
		int p2 = 0;
		int p3 = 0;

		for (int i = 0; i < answers.length; i++) {

			if (pt1[i % 5] == answers[i]) {
				p1++;
			}
			if (pt2[i % 8] == answers[i]) {
				p2++;
			}
			if (pt3[i % 10] == answers[i]) {
				p3++;
			}
		}

		score[0] = p1;
		score[1] = p2;
		score[2] = p3;

		int max = 0;
		max = Math.max(p1, p2);
		max = Math.max(max, p3);

		for (int i = 0; i < score.length; i++) {
			if (score[i] == max) {
				winner++;
				answer[i] = i + 1;
			}
		}

		int[] result = new int[winner];

		for (int i = 0; i < result.length; i++) {
			result[i] = answer[i];
		}

		return result;
	}

}