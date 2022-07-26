package Baekjoon_2864;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		
		String N = str[0];
		String M = str[1];
		
		int N_min, N_max, M_min, M_max;
		
		N_min = Integer.parseInt(N.replaceAll("6", "5"));
		N_max = Integer.parseInt(N.replaceAll("5", "6"));
		M_min = Integer.parseInt(M.replaceAll("6", "5"));
		M_max = Integer.parseInt(M.replaceAll("5", "6"));
		
		System.out.printf("%d %d\n", N_min+M_min, N_max+M_max);
		
		sc.close();
	}
}
