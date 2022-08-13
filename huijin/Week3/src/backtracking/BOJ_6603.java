package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6603 {
	private static int[] numbers= new int[6];
	private static int[] arr;
	private static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] str = br.readLine().split(" ");
			if(str[0].equals("0"))break;
			
			int k = Integer.parseInt(str[0]);
			arr = new int[k];
			for(int i=0;i<k;i++)arr[i]=Integer.parseInt(str[i+1]);
			
			comb(0,0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void comb(int start,int n) {
		if(n==6) {
			for(int i=0;i<6;i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<arr.length;i++) {
			numbers[n]=arr[i];
			comb(i+1,n+1);
		}
		
	}
}
