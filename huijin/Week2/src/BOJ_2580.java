import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2580 {
	static int map[][];
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//스도쿠 입력받기
		map = new int[9][9];
		for(int i=0;i<9;i++) {
			String str[] = br.readLine().split(" ");
			for(int j=0;j<9;j++)map[i][j]=Integer.parseInt(str[j]);
		}
		sdoku(0,0);
	}
	
	public static void sdoku(int x,int y) {
		if(x==9&&y==0) {
			//끝에 도달하면 출력. x: 0~8까지 index. 9로 넘어가면 스도쿠 완성된다.
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(map[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0); //스도쿠 완성한 것을 하나 찾으면 출력하고 바로 종료해야한다
			//무조건 하나만 출력해야 함..!
		}
		if(y==9) {
			//열이 끝에 도달하면, 다음 행으로 넘어가기
			sdoku(x+1,0);
			return;
		}
		
		if(map[x][y]==0) {//0이면, 1~9부터 보면서 들어갈 수 확인
			for(int i=1;i<=9;i++) {
				if(checking(x,y,i)) {
					map[x][y]=i;
					sdoku(x,y+1);
				}
			}
			map[x][y]=0; //이전으로 다시 돌아가기. 백트래킹
			return;
		}
		
		//map[x][y]가 0이 아니라면 그다음 열 확인
		sdoku(x,y+1);
	}
	
	public static boolean checking(int x, int y, int n) {
		
		//가로,세로 체크
		for(int i=0;i<9;i++) {
			if(map[x][i]==n)return false; //가로 체크
			if(map[i][y]==n)return false; //세로 체크
		}

		
		//3*3 확인
		int sx = (x/3)*3;
		int sy = (y/3)*3;
		
		for(int i=sx;i<sx+3;i++) {
			for(int j=sy;j<sy+3;j++) {
				if(map[i][j]==n)return false;
			}
		}
		
		//가로, 세로, 3*3 에 다 겹치는 수가 없으면 true 반환
		return true;
	}
}
