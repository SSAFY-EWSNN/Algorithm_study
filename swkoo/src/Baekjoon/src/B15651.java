package Baekjoon.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15651 {
	// N과 M(3) : 중복 순열
	static int N,M;
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
		
		for(int i =1; i<=N; i++) {
			numbers[count] = i;
			dupPerm(count+1);
		}
		

		
	}
}
