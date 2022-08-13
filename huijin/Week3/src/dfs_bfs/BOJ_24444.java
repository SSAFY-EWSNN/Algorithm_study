package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

class Node implements Comparable<Node>{
	int weight;
	int num;
	List<Node> nodes;
	
	Node(int num){
		weight=1;
		this.num=num;
		nodes = new ArrayList<Node>();
	}
	//노드 연결
	void add(Node node) {
		nodes.add(node);
	}
	
	void sort() {
		Collections.sort(nodes);
	}
	
	@Override
	public int compareTo(Node o) {
		return this.num - o.num;
	}
}
public class BOJ_24444 {
	private static int N, M, R;
	private static Node[] nodes;
	private static int[] order;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		
		//노드 N개 초기화
		nodes = new Node[N+1];
		for(int i=1;i<=N;i++)nodes[i]=new Node(i);
		
		
		//간선 입력받기
		for(int i=0;i<M;i++) {
			str = br.readLine().split(" ");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);
			nodes[u].add(nodes[v]); //간선 연결
			nodes[v].add(nodes[u]);
		}
		
		order = new int[N+1]; //순서 초기화
		bfs(R); //시작점 R부터 시작해 bfs
		
		for(int i=1;i<=N;i++) {
			sb.append(order[i]+"\n");
		}
		System.out.println(sb);
	}
	public static void bfs(int n) {
		//linkedlist보다 arraydeque가 더 빠르다
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1]; //방문여부 확인
		int s=1;
		//시작점 큐에 넣어주기
		queue.add(n);
		order[n]=s;
		visited[n]=true;
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			
			nodes[a].sort(); //a 노드와 연결된 간선들 오름차순 정렬
			for(Node node:nodes[a].nodes) {
				//아직 방문하지 않았으면 queue 에 넣어준다
				if(!visited[node.num]) {
					visited[node.num]=true;
					order[node.num]=++s; //이전 노드의 순서 +1로 순서 업데이트
					queue.add(node.num);
				}
			}
		}
		
	}
}
