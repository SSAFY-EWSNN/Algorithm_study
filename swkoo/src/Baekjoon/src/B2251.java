package Baekjoon.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2251 {
    // 백준 2251 물통
    static int A,B,C;
    static boolean[][][] visited;
    static Queue<int[]> q;
    static Set<Integer> ans;

    public static void main(String[] args) throws IOException {
        // 백준 물통
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[A+1][B+1][C+1];
        q = new LinkedList<>();
        ans = new LinkedHashSet<>();

        bfs();

        TreeSet<Integer> treeSet = new TreeSet<>(ans);
        for(int a:treeSet) {
            sb.append(a+" ");
        }

        System.out.println(sb);

    }

    static void bfs() {
        q.offer(new int[] {0,0,C});
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            if(visited[poll[0]][poll[1]][poll[2]]) continue;
            visited[poll[0]][poll[1]][poll[2]] = true;
            if(poll[0]==0) ans.add(poll[2]);

            // A -> B
            if(poll[0]+poll[1] > B) {
                q.add(new int[] {poll[0] + poll[1] - B, B, poll[2]});
            } else {
                q.add(new int[] {0, poll[0]+poll[1], poll[2]});
            }

            // B -> A
            if(poll[0]+poll[1] > A) {
                q.add(new int[] {A, poll[0] + poll[1] - A, poll[2]});
            } else {
                q.add(new int[] {poll[0] + poll[1], 0, poll[2]});
            }

            // A -> C
            if(poll[0]+poll[2] > C) {
                q.add(new int[] {poll[0] + poll[2] - C, poll[1], C});
            } else {
                q.add(new int[] {0, poll[1], poll[0]+poll[2]});
            }

            // C -> A
            if(poll[0]+poll[2] > A) {
                q.add(new int[] {A, poll[1], poll[0]+poll[2]-A});
            } else {
                q.add(new int[] {poll[0]+poll[2], poll[1], 0});
            }

            // B -> C
            if(poll[1]+poll[2] > C) {
                q.add(new int[] {poll[0], poll[1]+poll[2]-C, C});
            } else {
                q.add(new int[] {poll[0], 0, poll[1]+poll[2]});
            }

            // C -> B
            if(poll[1]+poll[2] > B) {
                q.add(new int[] {poll[0], B, poll[1]+poll[2]-B});
            } else {
                q.add(new int[] {poll[0], poll[1]+poll[2], 0});
            }
        }
    }
}
