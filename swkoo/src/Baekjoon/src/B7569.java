package Baekjoon.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B7569 {

    static int N, M, H;

    static Queue<int[]> q;
    static boolean[][][] visited;

    static ArrayList<int[][]> list;

    public static void main(String[] args) throws IOException {
        // 백준 토마토
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        q = new LinkedList<>();
        visited = new boolean[H][N][M];

        for(int i=0; i<H; i++) {
            int[][] arr = new int[N][M];
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    if(arr[j][k] == 1) {
                        q.offer(new int[] {i, j, k});
                    }
                }
            }
//            for(int a =0; a< N; a++) {
//                for(int b=0; b<M; b++) {
//                    System.out.print(arr[a][b]+" ");
//                }
//                System.out.println();
//            }
            list.add(arr);
        }



        StringBuilder sb = new StringBuilder();
        sb.append(bfs());
        System.out.println(sb);

    }

    static int bfs() {
        boolean isPerfect = true;
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(list.get(i)[j][k] == 0) {
                        isPerfect = false;
                    }
                }
            }
        }
        if(isPerfect) {
            return 0;
        }


        while(!q.isEmpty()) {
            int[] poll = q.poll();
            if(visited[poll[0]][poll[1]][poll[2]]) continue;
            visited[poll[0]][poll[1]][poll[2]] = true;

            // 앞
//            if (H > 1 && poll[0]-1 >= 0 && list.get(poll[0]-1)[poll[1]][poll[2]] == 0) {
            if (H > 1 && poll[0]-1 >= 0 && list.get(poll[0]-1)[poll[1]][poll[2]] != -1) {
                list.get(poll[0]-1)[poll[1]][poll[2]] += 1;
                q.add(new int[] {poll[0]-1, poll[1], poll[2]});
            }

            // 뒤
//            if (H > 1 && poll[0]+1 < H && list.get(poll[0]+1)[poll[1]][poll[2]] == 0) {
            if (H > 1 && poll[0]+1 < H && list.get(poll[0]+1)[poll[1]][poll[2]] != -1) {
                list.get(poll[0]+1)[poll[1]][poll[2]] += 1;
                q.add(new int[] {poll[0]+1, poll[1], poll[2]});
            }

            // 위
//            if (poll[1]-1 >= 0 &&list.get(poll[0])[poll[1]-1][poll[2]] == 0) {
            if (poll[1]-1 >= 0 &&list.get(poll[0])[poll[1]-1][poll[2]] != -1) {
                list.get(poll[0])[poll[1]-1][poll[2]] += 1;
                q.add(new int[] {poll[0], poll[1]-1, poll[2]});
            }

            // 아래
//            if (poll[1]+1 < N &&list.get(poll[0])[poll[1]+1][poll[2]] == 0) {
            if (poll[1]+1 < N &&list.get(poll[0])[poll[1]+1][poll[2]] != -1) {
                list.get(poll[0])[poll[1]+1][poll[2]] += 1;
                q.add(new int[] {poll[0], poll[1]+1, poll[2]});
            }

            // 왼쪽
//            if (poll[2]-1 >= 0 &&list.get(poll[0])[poll[1]][poll[2]-1] == 0) {
            if (poll[2]-1 >= 0 &&list.get(poll[0])[poll[1]][poll[2]-1] != -1) {
                list.get(poll[0])[poll[1]][poll[2]-1] += 1;
                q.add(new int[] {poll[0], poll[1], poll[2]-1});
            }

            // 오른쪽
//            if (poll[2]+1 < M &&list.get(poll[0])[poll[1]][poll[2]+1] == 0) {
            if (poll[2]+1 < M &&list.get(poll[0])[poll[1]][poll[2]+1] != -1) {
                list.get(poll[0])[poll[1]][poll[2]+1] += 1;
                q.add(new int[] {poll[0], poll[1], poll[2]+1});
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(list.get(i)[j][k] == 0) {
                        return -1;
                    }
                    ans = Math.max(ans, list.get(i)[j][k]);
//                    System.out.print(list.get(i)[j][k]+" ");
                }
//                System.out.println();
            }
//            System.out.println();
        }

        if(ans == 1) return 0;

        return ans-2;
    }
}
