package D1.d1936;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////

class Solution {
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(System.in)) {
        // int T;
        // T = sc.nextInt();

        // for (int test_case = 0; test_case <= T; test_case++) {
        // if (test_case < T)
        // System.out.print(T - (test_case) + " ");
        // else
        // System.out.print(T - (test_case));

        // }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        // 가위 : 1, 바위 : 2, 보 : 3
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);

        if (A - B > 0) {
            if (B == 1) {
                System.out.println("B");
            } else {
                System.out.println("A");
            }
        } else {
            if (A == 1) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }

    }
}