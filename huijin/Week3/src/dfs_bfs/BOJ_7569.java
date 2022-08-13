package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_7569 {
	private static int N, M, H;
	private static int[][][] tomato;
	private static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		H = Integer.parseInt(str[2]);
		tomato = new int[H][N][M]; //3차원 배열 토마토
		visited = new boolean[H][N][M]; //방문여부 체크
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				str = br.readLine().split(" ");
				for(int z=0;z<M;z++)tomato[i][j][z]=Integer.parseInt(str[z]);
			}
		}
		
		System.out.println(bfs());
	}
	public static int bfs() {
		int[] dz = {-1,1,0,0,0,0};
		int[] dx = {0,0,1,-1,0,0};
		int[] dy = {0,0,0,0,1,-1};
		
		int answer= -1;
		Queue<int[]> queue = new ArrayDeque<int[]>();
		
		boolean flag = false; //모든 토마토가 익었는지 확인하기 위한 flag
		//익은 토마토들을 시작 위치로 잡음. queue에 처음 넣어준다!
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int z=0;z<M;z++) {
					if(tomato[i][j][z]==1) {
						queue.add(new int[] {i,j,z,0}); //뒤의 0은 걸린 시간
						visited[i][j][z]=true;
					}
					else if(tomato[i][j][z]==0)flag=true;
				}
			}
		}
		//만약 0인 토마토 (익지 않은 토마토)가 없으면, 0을 리턴
		if(!flag)return 0; 
		
		while(!queue.isEmpty()) {
			int[] a= queue.poll();
			
			//익는데 모두 걸리는 시간 체크
			answer = Math.max(answer, a[3]);
			
			for(int i=0;i<6;i++) { //6방향에 대해 체크
				int z = a[0]+dz[i];
				int x = a[1]+dx[i];
				int y = a[2]+dy[i];
				
				if(z<0||z>=H||x<0||x>=N||y<0||y>=M)continue; //범위를 벗어나면 다음으로
				
				if(!visited[z][x][y] && tomato[z][x][y]==0) { //익지 않은 토마토 - 아직 방문하지 않았다면
					visited[z][x][y]=true;
					queue.add(new int[] {z,x,y,a[3]+1}); //queue에 넣어주기. 걸린 시간 +1 해준다
				}
			}
		}
		
		//방문하지 않은 토마토가 있는지 확인
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int z=0;z<M;z++) {
					//0인 토마토가 visited = false 면, 아직 방문하지 않았다는 소리다. -1 반환
					if(tomato[i][j][z]==0 && visited[i][j][z]==false)return -1;
				}
			}
		}
		
		return answer;
	}
}
