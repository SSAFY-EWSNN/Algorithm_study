package Baekjoon.src.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15683_감시 {

    static class Cctv {
        int x,y,type;

        public Cctv(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    static int N,M;
    // 상 우 하 좌
    static int[] dirX = {-1,0,1,0};
    static int[] dirY = {0,1,0,-1};
    // 카메라 방향은 총 4방향
    static int[] numbers; // 중복순열에서 선택 된 카메라 방향 ([0,0,0,0] ~ [3,3,3,3])
    static List<Cctv> cctvs;
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("swkoo/src/Baekjoon/src/simulation/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cctvs = new ArrayList<>();
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(new Cctv(i,j,map[i][j]));
                }
            }
        }
        numbers = new int[cctvs.size()];
        ans = Integer.MAX_VALUE;

        perm(0);

        sb.append(ans);
        System.out.println(sb);
    }

    static void perm(int count) {

        if(count == cctvs.size()) {

            int[][] copy = new int[N][M];
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    copy[i][j] = map[i][j];
                }
            }

            for(int cctvIndex = 0; cctvIndex<cctvs.size(); cctvIndex++) {
                Cctv curCctv = cctvs.get(cctvIndex);
                switch(curCctv.type) {
                    // 카메라 종류 별 탐색
                    case 1:
                        // numbers = [첫번째카메라 방향, 두번째카메라 방향, ..]
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]);
                        break;
                    case 2:
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]);
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]+2);
                        break;
                    case 3:
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]);
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]+1);
                        break;
                    case 4:
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]);
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]+1);
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]+3);
                        break;
                    case 5:
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]);
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]+1);
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]+2);
                        dfs(curCctv.x, curCctv.y,numbers[cctvIndex]+3);
                        break;
                }
            }

            // 사각지대 개수
            int sum = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] == 0) {
                        sum++;
                    }
                }
            }
            // 사각지대 최소 개수 갱신
            if(sum<ans) {
                ans = sum;
            }

            // 맵 원상복귀
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    map[i][j] = copy[i][j];
                }
            }
            return;
        }

        for(int i=0; i<4; i++) {
            numbers[count] = i;
            perm(count+1);
        }
    } // end perm

    static void dfs(int x, int y, int direction) {
        direction = direction % 4; // 0:상, 1:우, 2:하, 3:좌 / 4:상, 5:우, 6:하, 7:좌, ...
        int dx = x+dirX[direction];
        int dy = y+dirY[direction];
        if(check(dx,dy)) {
            // 탐색한 곳이 빈칸이면
            if(map[dx][dy] == 0) {
                // 탐색 마킹
                map[dx][dy] = -1;
                dfs(dx,dy,direction);
            }
            // 탐색한 곳이 cctv 이거나 이미 탐색 마킹 한 곳이면
            else if((map[dx][dy] >= 1 && map[dx][dy] <= 5) || map[dx][dy] == -1) {
                dfs(dx,dy,direction); // 그냥 지나가기
            }
        }
        // 벽을 만나거나, 경계를 벗어 날 경우 return;
        return;
    }

    static boolean check(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }


}