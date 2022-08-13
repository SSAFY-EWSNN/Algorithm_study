package backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16987 {
	private static int N;
	private static int[][] egg;
	private static int max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		egg = new int[N][2];
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split(" ");
			egg[i][0]=Integer.parseInt(str[0]);
			egg[i][1]=Integer.parseInt(str[1]);
		}
		backtracking(egg,0,0);
		System.out.println(max);		
	}
	//n은 현재 횟수, idx 는 현재 계란
	public static void backtracking(int[][] numbers,int n,int idx) {		
		if(idx>=N) { //계란 끝까지 다 봤다면  max값 업데이트
			//System.out.println(n);
			max=Math.max(max, n);
			return;
		}
		
		if(egg[idx][0]<=0) {
			//현재 계란이 깨져있으면 다음 계란으로 넘어감
			backtracking(numbers,n,idx+1);
			return;
		}
		int aa=0; //부딪히는 계란 수
		//현재 계란이 깨지지 않은 경우
		for(int i=0;i<N;i++) {
			if(i==idx)continue; //현재 계란 빼고 본다
			if(numbers[i][0]>0) { //계란 내구도가 깨지지 않았다면
				aa++;
				int n2=n;
				numbers[i][0]-=numbers[idx][1];
				numbers[idx][0]-=numbers[i][1];
				if(numbers[i][0]<=0)n2+=1;
				if(numbers[idx][0]<=0)n2+=1;
				//System.out.println(n2);
				backtracking(numbers,n2,idx+1);
				//계란 상태 원상복구
				numbers[i][0]+=numbers[idx][1];
				numbers[idx][0]+=numbers[i][1];
			}
		}
		//깰 계란이 없었다면 다음 계란으로 넘어감
		if(aa==0)backtracking(numbers,n,idx+1);
	}
}
