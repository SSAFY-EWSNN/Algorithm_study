package Baekjoon.src.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S5644_무선충전 {

    static class BC {
        int x, y, c, p;
        boolean haveA;
        boolean haveB;

        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
            this.haveA = false;
            this.haveB = false;
        }
    }

    static class User {
        int aX, aY, bX, bY;

        public User(int aX, int aY, int bX, int bY) {
            this.aX = aX;
            this.aY = aY;
            this.bX = bX;
            this.bY = bY;
        }
    }


    static int M, A;
    static int[] moveA, moveB;
    static List<BC> bcList;
    static User user;
    static int ANS;
    static int[] dirX = {0, 0, 1, 0, -1};
    static int[] dirY = {0, -1, 0, 1, 0};

    // 이 문제에서는 x가 가로 이동 y가 세로 이동
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("swkoo/src/Baekjoon/src/simulation/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            moveA = new int[M + 1];
            moveB = new int[M + 1];
            bcList = new ArrayList<>();
            ANS = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                bcList.add(new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            user = new User(1, 1, 10, 10);

            solution();


            sb.append("#").append(tc).append(" ");
            sb.append(ANS).append("\n");
        }
        System.out.println(sb);
    }

    static void solution() {
        for (int t = 0; t <= M; t++) {

            // 사용자 이동
            user.aX += dirX[moveA[t]];
            user.aY += dirY[moveA[t]];
            user.bX += dirX[moveB[t]];
            user.bY += dirY[moveB[t]];
//            System.out.println(t+"초 A좌표-"+ user.aX+","+ user.aY);

            int max = 0;

            for (int i = 0; i < A; i++) {
                BC bc = bcList.get(i);
                // BC 접속 여부 업데이트
                bc.haveA = checkDistance(bc, user.aX, user.aY, bc.x, bc.y);
                bc.haveB = checkDistance(bc, user.bX, user.bY, bc.x, bc.y);
//                System.out.println(t+"초 "+(i+1)+"번 BC("+bc.x+","+bc.y+") : A-"+bc.haveA+" B-"+bc.haveB+" A좌표-"+ user.aX+","+ user.aY);
            }

            for (int i = 0; i < A; i++) {
                BC bc = bcList.get(i);
                // 충전량 증가
                for (int j = 0; j < A; j++) {
                    BC bc2 = bcList.get(j);
                    int sum = 0;
                    if (i == j) { // 현재 BC에서 모두 충전
                        if (bc.haveA && bc.haveB) {
                            // A, B 둘다 같은 BC에서 충전
                            sum += bc.p / 2;
                            sum += bc.p / 2;
                        } else if (bc.haveA && !bc2.haveB) {
                            // A 만 BC 안에 있을 때
                            sum += bc.p;
                        } else if (!bc.haveA && bc2.haveB) {
                            // B만 BC 안에 있을 때
                            sum += bc.p;
                        }
                    } else { // 서로 다른 BC에서 충전
                        if (bc.haveA && bc2.haveB) {
                            // A, B 둘다 각각 다른 BC에서 충전
                            sum += bc.p;
                            sum += bc2.p;
                        } else if (bc.haveA && !bc2.haveB) {
                            // A 만 BC 안에 있을 때
                            sum += bc.p;
                        } else if (!bc.haveA && bc2.haveB) {
                            // B 만 BC 안에 있을 때
                            sum += bc2.p;
                        }
                    }

                    max = Math.max(max, sum);

                }
            }
            ANS += max;
        }
    }


    static boolean checkDistance(BC bc, int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2) <= bc.c;
    }
}
