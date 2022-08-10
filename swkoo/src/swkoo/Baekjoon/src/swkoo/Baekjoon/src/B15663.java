package swkoo.Baekjoon.src;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class B15663 {
	// N과 M(9) 순열 (중복출력제거) - input data
	static int N, M;
	static int[] inputArray;
	static int[] numbers;
	static LinkedHashSet<String> output;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		output = new LinkedHashSet<>();
		inputArray = new int[N];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputArray);


		perm(0);
		
		for(String s:output) {
			sb.append(s);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

	private static void perm(int count) {
		if (count == M) {
			String str = "";
			for (int a : numbers) {
				str+= a+" ";
			}
			output.add(str);
			return;
		}

		for (int i = 0; i < N; i++) {

			if(isSelected[i])continue;
			
			numbers[count] = inputArray[i];
			isSelected[i] = true;
			perm(count+1);
			isSelected[i] = false;
			
		}

	}
}
