package Baekjoon.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15654 {
	// N과 M (5) 순열 - input data
	static StringBuilder sb = new StringBuilder();
	static int[] inputArray;
	static int[] numbers;
	static boolean[] isSelected;
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		
		inputArray = new int[N];
		numbers = new int[M];
		isSelected = new boolean[N];
		
		for(int i =0; i<N; i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inputArray);
		
		perm(0);
		System.out.println(sb.toString());
	}
	
	private static void perm(int count) {
		if(count == M) {
			for(int a:numbers) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			
			numbers[count] = inputArray[i];
			isSelected[i] = true;
			
			perm(count+1);
			isSelected[i] = false;
			
		}
	}
	
	
	
}
