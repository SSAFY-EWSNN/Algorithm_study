package samgsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BOJ_14502 {
	private static int N,M;
	private static int[][] map;
	private static List<int[]> virus;
	private static int max_area=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str= br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N][M];
		virus = new ArrayList<>();
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(str[j]);
				//virus 위치 확인하기
				if(map[i][j]==2)virus.add(new int[] {i,j});
			}
		}
		
		comb(0,0,0);
		
		System.out.println(max_area);
		
	}
	
	public static void comb(int x, int y,int n) {
		if(n==3) {
			//안전영역 확인
			max_area=Math.max(max_area, bfs());
			return;
		}
				
		for(int i=x;i<N;i++) {
			for(int j=y;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1; //벽 설치
					System.out.println("i: "+i+" j: "+j);
					comb(((j==M-1)?(i+1):i),(j+1)%M,n+1);
					System.out.println(i+" "+j);

					//System.out.println(((j==M-1)?(i+1):i)+" "+(j+1)%M);
					System.out.println("====================");
					map[i][j]=0; //다시 해제
				}
			}
		}
	}
	
	public static int bfs() {
		int answer=0;
		//델타
		int[] dir_x = {-1,0,1,0};
		int[] dir_y = {0,1,0,-1};
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		//map 복사
		int[][] cmap=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)cmap[i][j]=map[i][j];
		}
		//virus queue 에 넣어주기
		for(int[] aa:virus) {
			queue.add(aa);
		}
		
		while(!queue.isEmpty()) {
			int[] a= queue.poll();
			
			for(int i=0;i<4;i++) {
				int dx = a[0]+dir_x[i];
				int dy = a[1]+dir_y[i];
				if(dx<0||dx>=N||dy<0||dy>=M)continue;
				
				if(cmap[dx][dy]==0) {
					cmap[dx][dy]=2;
					queue.add(new int[] {dx,dy});
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(cmap[i][j]==0)answer+=1;
			}
		}
		return answer;
	}
}
