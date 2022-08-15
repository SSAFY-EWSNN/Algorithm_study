package swkoo.SWEA.src.D1.d2019;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int T;
            T = sc.nextInt();
            int result = 1;
            System.out.print(1 + " ");
            for (int i = 1; i <= T; i++) {
                result = result * 2;
                if (i == T) {
                    System.out.print(result);
                    break;
                }
                System.out.print(result + " ");
            }
        }
    }
}