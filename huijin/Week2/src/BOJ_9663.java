import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
	static int answer=0;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		backtracking(0,new int[n]); //백트래킹 호출
		System.out.println(answer);
	}
	
	public static void backtracking(int now_x,int[] visit) {
		if(now_x==n) { //n에 도달하면 정답 카운트
			answer+=1;
		}
		
		//퀸 놓을 수 있는 자리 확인
		for(int i=0;i<n;i++) {
			boolean chk=true;
			//이때까지 놓인 퀸 확인
			for(int j=0;j<now_x;j++) {
				//세로로 동일하면 break
				if(i==visit[j]) {
					chk = false;
					break;
				}
				
				//같은 대각선에 있으면 break
				if(Math.abs(now_x-j)==Math.abs(i-visit[j])) {
					chk=false;
					break;
				}
			}

			//세로, 대각선에 겹치는게 없다면 현재 위치에 퀸을 놓고,
			//다음 행으로 backtracking 함수 재귀호출해준다.
			if(chk) {
				visit[now_x]=i;
				backtracking(now_x+1,visit);
			}
			
		}
		
		
	}

}