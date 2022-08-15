package Baekjoon.src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B24479 {
    // 백준 : 알고리즘 수업 - 깊이 우선 탐색 1
    static int N, M, R, count;
    static int[] visited;
    static ArrayList<Integer>[] edge;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        count = 0;
        visited = new int[N+1];
        edge = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            edge[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edge[u].add(v);
            edge[v].add(u);
        }

        for(int i=1; i<=N; i++) {
            edge[i].sort(null);
        }

        dfs(R);

        for(int i=1; i<=N; i++) {
            sb.append(visited[i]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dfs (int r) {
        visited[r] = ++count;
        for(int a : edge[r]) {
            if(visited[a] > 0) { // visited[a] 가 0보다 크면 이미 방문한 정점
                continue;
            }
            dfs(a);
        }
    }

}
