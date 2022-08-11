package Baekjoon_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt = 0;
	static int[] arr;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		nQueen(0);
		System.out.println(cnt);
	}

	static void nQueen(int depth) {
		if(depth == N) {
			cnt++;
			return;
		}

		for(int i = 0; i < N; i++) {
			arr[depth] = i;
			if(Possibility(depth)) {
				nQueen(depth + 1);
			}
		}
	}
	public static boolean Possibility(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			} 
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}

		return true;
	}
}

