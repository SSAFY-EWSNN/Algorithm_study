package swkoo.Baekjoon.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15657 {
	// N과 M(8) 중복조합 - input data
	static int N, M;
	static int[] inputArray;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		inputArray = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputArray);


		dupComb(0, 0);
		
		System.out.println(sb.toString());

	}

	private static void dupComb(int count, int start) {
		if (count == M) {
			for (int a : numbers) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {

			numbers[count] = inputArray[i];

			dupComb(count + 1, i);
			
		}

	}
}
