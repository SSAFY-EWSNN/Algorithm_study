import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
        List<Integer> result = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] inputAj = new int[N];
            int[] inputBj = new int[M];

            for(int i=0; i<inputAj.length;i++) inputAj[i] = sc.nextInt();
            for(int i=0; i<inputBj.length;i++) inputBj[i] = sc.nextInt();

            int smallArraySize = 0;
            int largeArraySize = 0;
            
            int max = 0;
            
            if(N > M) {
                smallArraySize = M;
                largeArraySize = N;
            }
            else {
                smallArraySize = N;
                largeArraySize = M;
            }


            if(N > M) {
                // i : largeArrayIndex (Aj)
                for(int i = 0; i <= largeArraySize - smallArraySize; i++) {
                    int sum = 0;
                    
                    // j : smallArrayIndex (Bj)
                    for(int j = 0; j < smallArraySize ; j++) {
                        sum += (inputAj[i+j] * inputBj[j]);
                        
                        
                    }
                    if(sum > max) {
                        max = sum;                            
                    }
                }
            }

            else {
                // i : largeArrayIndex (Aj)
                for(int i = 0; i <= largeArraySize - smallArraySize; i++) {
                    int sum = 0;
                    // j : smallArrayIndex (Bj)
                    for(int j = 0; j < smallArraySize ; j++) {
                        sum = sum + inputBj[i+j] * inputAj[j];
                    }
                    if(sum > max) {
                        max = sum;                            
                    }
                }
            }
            result.add(max);
            
		}
        for(int i = 0; i<result.size(); i++){
            System.out.printf("#%d %d\n",i+1,result.get(i));
        }
    
	}
}