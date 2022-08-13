package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1759 {
	private static char[] arr;
	private static int L, C;
	private static StringBuilder sb = new StringBuilder();
	private static char[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		L = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		//C 중에서 L개 순열.(중복X) 순열은 증가하는 순열
		//최소 한개의 모음과 최소 두개의 자음으로 구성
		//뒤 문자가 앞 문자보다 더 커야한다. ex) cba 가능 (abc 불가능) 
		arr = new char[C];
		check = new char[L];
		str = br.readLine().split(" ");
		for(int i=0;i<C;i++) {
			arr[i]=str[i].charAt(0);
		}
		Arrays.sort(arr); //사전순으로 나열하기 위해 정렬
		
		comb(0,0,0,0);
		
		System.out.print(sb);
	}
	
	public static void comb(int n,int bit, int mo, int ja) {
		if(n==L) {
			if(mo<1||ja<2)return;

			for(int i=0;i<L;i++) {
				sb.append(check[i]);
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<C;i++) {
			if((bit & 1<<i)!=0) continue; //이미 방문하면 넘어감
			if(n>=1 && check[n-1]>=arr[i])continue; //앞의 문자가 더 크면, 넘어감
			int mo2 = mo;
			int ja2 = ja;
			if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u')mo2+=1;
			else ja2+=1;
			check[n]=arr[i];
			comb(n+1, (bit|1<<i),mo2,ja2);
			
		}
	}
}
