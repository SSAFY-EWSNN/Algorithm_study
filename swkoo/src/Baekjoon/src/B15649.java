package Baekjoon.src;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15649 {
	// N과 M(1)
	static int N, M;
	static boolean[] isSelected;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		// N과 M(1) 순열
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		isSelected = new boolean[N + 1];

		permutation(0);

	}

	private static void permutation(int count) {
		if (count == M) {
			for (int a : numbers) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {

			if (isSelected[i]) {
				continue;
			}

			numbers[count] = i;
			isSelected[i] = true;

			permutation(count + 1);

			isSelected[i] = false;

		}

	}
}
