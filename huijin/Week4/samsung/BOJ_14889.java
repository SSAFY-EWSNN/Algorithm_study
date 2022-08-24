package samgsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//스타트와 링크
public class BOJ_14889 {
	private static int N;
	private static int[][] exp;
	private static int[] start;
	private static int[] rink;
	private static boolean[] check;
	private static int answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		N = Integer.parseInt(br.readLine());
		exp = new int[N][N];
		check=new boolean[N];
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0;j<N;j++)exp[i][j]=Integer.parseInt(str[j]);
		}
		start=new int[N/2];
		rink = new int[N/2];
		comb(0,0);
		
		System.out.print(answer);
	}
	//조합 구하기
	public static void comb(int s, int n) {
		if(n==N/2) {
			int c=0;
			int score1=0;
			int score2=0;
			for(int i=0;i<N;i++) {
				if(!check[i])rink[c++]=i;
			}
			
			for(int i=0;i<N/2;i++) {
				for(int j=i;j<N/2;j++) {
					score1+=exp[start[i]][start[j]];
					score1+=exp[start[j]][start[i]];
					score2+=exp[rink[i]][rink[j]];
					score2+=exp[rink[j]][rink[i]];
				}
			}
			
			answer=Math.min(answer, Math.abs(score1-score2));
			return;
		}
		for(int i=s;i<N;i++) {
			start[n]=i;
			check[i]=true;
			comb(i+1,n+1);
			check[i]=false;
		}
	}
}
