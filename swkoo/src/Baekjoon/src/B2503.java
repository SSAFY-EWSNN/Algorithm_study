package Baekjoon.src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2503 {
	// 숫자 야구
	static int N;
	static List<BaseBallData> inputList = new ArrayList<>(); // 리스트로 input data 관리

	static class BaseBallData {
		// 데이터 전체를 하나의 객체로 만들어 리스트에 집어 넣어서 관리하기 위해 클래스 생성
		int num;
		int strike;
		int ball;

		public BaseBallData(int num, int strike, int ball) {
			this.num = num;
			this.strike = strike;
			this.ball = ball;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());

			// 입력 받은 데이터들로 BaseBallData 객체를 생성해 inputList 리스트에 저장
			BaseBallData data = new BaseBallData(num, strike, ball);
			inputList.add(data);
		}

		System.out.println(play());
	}

	static int play() {
		// 메인 로직

		int ans = 0; // 정답이 될 수 있는 수의 개수

		for (int i = 123; i <= 987; i++) {

			if (checkDuplNum(i))
				continue; // 중복 숫자거나 0이 들어가면 continue;

			int count = 0; // 입력한 숫자와 스트라이크, 볼의 개수가 일치 할 경우 증가하는 카운트

			/*
			 * 1. 123 <= i <= 987 범위의 for loop를 돌며 i(정답이 될 수도 있는 수)와 입력한 숫자의 스트라이크와 볼을 센다.
			 * 2. i for loop를 돌면서 입력한 숫자의 스트라이크, 볼의 수와 같은 스트라이크, 볼의 수를 갖는 숫자들이 정답이라고 생각할 수있는 숫자이다.
			 * 
			 */
			for (int j = 0; j < N; j++) {

				int strikeCount = 0; // 스트라이크의 개수
				int ballCount = 0; // 볼의 개수

				BaseBallData inputData = inputList.get(j); // 입력한 숫자, 스트라이크의 개수, 볼의 개수가 들어있는 j번째 객체 선언
				String inputNumber = Integer.toString(inputData.num); // 입력한 숫자를 문자열로 변환
				String checkNumber = Integer.toString(i); // i를 문자열로 변환

				// 스트라이크
				for (int s = 0; s < 3; s++) {
					// 입력한 숫자와 i가 스트라이크 : 같은 숫자가 같은 자리수(스트라이크)에 있을 경우 strikeCount 증가
					if (inputNumber.charAt(s) == checkNumber.charAt(s)) {
						strikeCount++;
					}
				}

				// 볼
				for (int b = 0; b < 3; b++) {
					for (int c = 0; c < 3; c++) {
						// 입력한 숫자와 i가 볼 : 같은 숫자가 있고 같은 자리수(스트라이크)가 아닐 경우 ballCount 증가
						if (checkNumber.charAt(b) == inputNumber.charAt(c) && b != c) {
							ballCount++;
						}
					}
				}

				// 숫자i가 입력한 숫자와 스트라이크, 볼의 개수가 일치하다면 count 증가
				if (inputData.strike == strikeCount && inputData.ball == ballCount) {
					count++;
				}
			}

			// i가 모든 입력한 숫자들과 스트라이크, 볼의 개수가 일치하다면 정답이 될수 있는 수이므로 ans 증가
			if (count == N) {
				ans++;
			}

		}
		return ans;
	}

	static boolean checkDuplNum(int num) {
		// 정수를 입력 받아 문자 배열로 변환해 같은 문자가 있는지 검사
		// return / true : 중복 있음, false : 중복 없음

		char[] c_num = String.valueOf(num).toCharArray();

		for (int i = 0; i < c_num.length; i++) {
			if (c_num[i] == '0')
				return true;
		}

		if (c_num[0] == c_num[1] || c_num[1] == c_num[2] || c_num[0] == c_num[2])
			return true;

		return false;
	}

}
