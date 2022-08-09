package swkoo.Baekjoon.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15656 {
	// N과 M (7) 중복순열 - input data
	static int N,M;
//	static boolean[] isSelected;
	static int[] numbers;
	static int[] inputArray;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inputArray = new int[N];
		numbers = new int[M];
//		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputArray);
		dupPerm(0);
		
		System.out.println(sb);
	}
	
	private static void dupPerm(int count) {
		
		if(count == M) {
			for(int a:numbers) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			
//			if(isSelected[i])continue;
			
			numbers[count] = inputArray[i];
//			isSelected[i] = true;
			
			dupPerm(count+1);
			
//			isSelected[i] = false;
			
		}
		
	}
}
