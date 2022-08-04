package swkoo.Baekjoon.src;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.stream.events.StartDocument;

public class B15650 {
	// N과 M(2) : 조합

	static int N, M;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		isSelected = new boolean[N + 1];

		comb(0,1);

	}

	private static void comb(int count, int start) {
		if (count == M) {
			for (int a : numbers) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			if (isSelected[i]) {
				continue;
			}

			numbers[count] = i;
			isSelected[i] = true;

			comb(count + 1, i+1);

			isSelected[i] = false;

		}
	}
}
