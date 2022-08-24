package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class BOJ_1261 {
	private static int[] dir_x = {1,0,-1,0};
	private static int[] dir_y = {0,1,0,-1};
	private static int N,M;
	private static int[][] map;
	private static boolean[][] visited;
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int cnt;
		
		public Point(int x,int y,int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		M=Integer.parseInt(str[0]);
		N=Integer.parseInt(str[1]);
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String s= br.readLine();
			for(int j=0;j<M;j++)map[i][j]=s.charAt(j)-'0';
		}
		

		System.out.println(bfs(0,0));
	}
	
	//그냥 큐 대신 우선순위 큐를 사용해서, 벽을 부수는 횟수가 제일 적은 위치를 우선적으로 고려하자
	public static int bfs(int x,int y) {
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		int answer=0;
		queue.add(new Point(x,y,0));
		visited[x][y]=true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(p.x==N-1&&p.y==M-1) {
				answer=p.cnt;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int dx = p.x+dir_x[i];
				int dy = p.y+dir_y[i];
				
				//영역 체크
				if(dx<0||dx>=N||dy<0||dy>=M)continue;
				
				if(!visited[dx][dy]) {
					visited[dx][dy]=true;
					if(map[dx][dy]==1)queue.add(new Point(dx,dy,p.cnt+1));
					else queue.add(new Point(dx,dy,p.cnt));
				}
				
			}
		}
		return answer;
	}
	
}
