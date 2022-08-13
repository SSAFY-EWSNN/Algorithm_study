package dfs_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//class Node implements Comparable<Node>{
//	int weight;
//	int num;
//	List<Node> nodes;
//	
//	Node(int num){
//		weight=1;
//		this.num=num;
//		nodes = new ArrayList<Node>();
//	}
//	//노드 연결
//	void add(Node node) {
//		nodes.add(node);
//	}
//	
//	void sort() {
//		Collections.sort(nodes);
//	}
//	
//	@Override
//	public int compareTo(Node o) {
//		return this.num - o.num;
//	}
//}

public class BOJ_24479 {
	static boolean[] visited;
	static Node[] arr;
	static int[] order;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int R = Integer.parseInt(str[2]);
		arr = new Node[N];
		visited = new boolean[N];
		order = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=new Node(i);
		}
		
		for(int i=0;i<M;i++) {
			str=br.readLine().split(" ");
			int a= Integer.parseInt(str[0]);
			int b= Integer.parseInt(str[1]);
			
			arr[a-1].add(arr[b-1]);
			arr[b-1].add(arr[a-1]);
		}
		
		//dfs 호출
		visited[R-1]=true;
		dfs(R-1);
		
		//출력
		for(int i=0;i<N;i++) {
			if(visited[i]) {
				sb.append(order[i]+"\n"); //순서 출력
			}
			else sb.append(0+"\n");
			
		}
		System.out.print(sb);
	}
	
	public static void dfs(int now) {
		visited[now]=true;
		order[now]=cnt+1;
		//기저조건
		
		arr[now].sort(); //오름차순 정렬
		List nodelist = arr[now].nodes;
		for(int i=0;i<nodelist.size();i++) {
			Node next = (Node) nodelist.get(i);
			if(!visited[next.num]) {
				cnt++;
				dfs(next.num);
			}
		}
	}
}
