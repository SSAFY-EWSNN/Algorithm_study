package SWEA.src.D2.d1979;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        List<Integer> result = new ArrayList<>();


		for(int test_case = 1; test_case <= T; test_case++)
		{
		
            int N = sc.nextInt();
            int K = sc.nextInt();
            int count = 0;

            int[][] array = new int[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    array[i][j] = sc.nextInt();
                }
            }

            // 가로
            for(int i=0; i<N; i++) {
                int temp = 0;
                for(int j=0; j<N; j++) {
                    if(array[i][j] == 0){
                        if(temp == K) {
                            count += 1;
                        }
                        temp = 0;
                    }
                    else {
                        temp += 1;
                    }
                }
                if(temp == K){
                    count += 1;
                }
            }

            // 세로
            for(int i=0; i<N; i++) {
                int temp = 0;
                for(int j=0; j<N; j++) {
                    if(array[j][i] == 0){
                        if(temp == K) {
                            count += 1;
                        }
                        temp = 0;
                    }
                    else {
                        temp += 1;
                    }
                }
                if(temp == K){
                    count += 1;
                }
            }

            result.add(count);
		}
        for(int i=0; i<result.size(); i++){
            System.out.printf("#%d %d\n",i+1, result.get(i));
        }
	}
}