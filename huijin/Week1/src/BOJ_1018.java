import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*체스판 다시 칠하기. M*N 보드에서 8*8 크기로 잘라서 체스판으로 색칠할 때,
칠해야 하는 최소한의 개수는?
*/

public class BOJ_1018 {
	static String[] map;
	static int m;
	static int n;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력 받아오기
		String str[] = br.readLine().split(" ");
		m = Integer.parseInt(str[0]);
		n = Integer.parseInt(str[1]);
		map = new String[m];
		
		
		for(int i=0;i<m;i++)map[i]=br.readLine(); //문자열 그대로 받는다. 잘려있지 않으니까 charAt으로 접근할 것
		
		//최솟값 저장
		int min = Integer.MAX_VALUE;
		
		//완전탐색. 8*8 체스 시작할 위치를 탐색한다
		for(int i=0;i<=m-8;i++) {
			for(int j=0;j<=n-8;j++) {
				//바꿔야하는 개수 최솟값을 반환해주는 함수 호출
				int a = color(i,j); 
				if(a<min)min=a;
			}
		}
		System.out.println(min);
		
	}
	
	/*
	흰 부터 시작
	행 + 열 더한 수가 짝수면 W, 홀수면 B
	-> 짝수일 때 B 이면 틀린 개수 카운트, 홀수일 때 W면 틀린 개수 카운트
	
	검 부터 시작
	행 + 열 더한 수가 짝수면 B, 홀수면 W
	-> 짝수일 때 W 이면 틀린 개수 카운트, 홀수일 때 B면 틀린 개수 카운트
	 */
	public static int color(int x,int y) {
		int cnt_b = 0; //검은색부터 시작하는 경우 틀린 갯수 count
		int cnt_w = 0; //흰색부터 시작하는 경우 틀린 개수 count
		
		
		//검은색부터 시작할 때 틀린 개수와 흰색부터 시작할 때 틀린 개수 count
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						if(map[x+i].charAt(y+j)=='W') {
							if((i+j)%2==0) {
								//짝수. 검은색부터 시작하면 틀림
								cnt_b +=1;
							}
							else {
								//홀수. 흰색부터 시작하면 틀림
								cnt_w +=1;
							}
						}
						
						else if(map[x+i].charAt(y+j)=='B') {
							if((i+j)%2==0) {
								//짝수. 흰부터 시작하면 틀림
								cnt_w+=1;
							}
							else {
								//홀수. 검부터 시작하면 틀림
								cnt_b +=1;
							}
						}
							
					}
				}
				
				return (cnt_w<=cnt_b)?cnt_w:cnt_b;
	}

}
