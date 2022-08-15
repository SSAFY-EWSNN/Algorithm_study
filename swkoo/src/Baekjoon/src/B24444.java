package swkoo.Baekjoon.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B24444 {

    static int N, M, R, count;
    static int[] visited;
    static ArrayList<Integer>[] edge;
    static Queue<Integer> queue;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        count = 0;
        visited = new int[N + 1];
        edge = new ArrayList[N + 1];
        queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edge[u].add(v);
            edge[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            edge[i].sort(null);
        }

        bfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs(int r) {
        visited[r] = ++count;
        queue.offer(r);
        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int a : edge[u]) {
                if (visited[a] > 0) { // visited[a] 가 0보다 크면 이미 방문한 정점
                    continue;
                }
                queue.offer(a);
                visited[a] = ++count;
            }
        }

    }

}
