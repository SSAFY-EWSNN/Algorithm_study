import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2580 {
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for(int i=0;i<9;i++) {
			String str[] = br.readLine().split(" ");
			for(int j=0;j<9;j++)map[i][j]=Integer.parseInt(str[j]);
		}
		
		dfs(0,0);
	}
	
	public static void dfs(int x, int y) {
		if(y == 9) {
			dfs(x+1,0);
			return;
		}
		
		if(x==9) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(map[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(map[x][y]==0) { //0이면 가능한 숫자 체크!
			for(int i=1;i<=9;i++) {
				if(check(x,y,i)) {
					map[x][y]=i;
					dfs(x,y+1);
				}
			}
			map[x][y] = 0;
			return;
		}
		dfs(x,y+1);
	}
	
	public static boolean check(int x, int y, int value) {
		
		//열 체크
		for(int i=0;i<9;i++) {
			if(map[x][i]==value) {
				return false;
			}
		}
		
		//행 체크
		for(int i=0;i<9;i++) {
			if(map[i][y]==value) {
				return false;
			}
		}
		
		//3*3 체크
		int start_x = (x/3)*3;
		int start_y = (y/3)*3;
		for(int i=start_x;i<start_x+3;i++) {
			for(int j=start_y;j<start_y+3;j++) {
				if(map[i][j]==value) {
					return false;
				}
			}
		}
		
		return true;
	}
}