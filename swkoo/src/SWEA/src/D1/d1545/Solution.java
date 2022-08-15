package swkoo.SWEA.src.D1.d1545;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int T;
            T = sc.nextInt();

            for (int test_case = 0; test_case <= T; test_case++) {
                if (test_case < T)
                    System.out.print(T - (test_case) + " ");
                else
                    System.out.print(T - (test_case));

            }
        }
    }
}