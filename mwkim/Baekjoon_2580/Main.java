import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			String[] num = in.readLine().split(" ");
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(num[j]);
			}
		}
		sdoku(0,0);
		
	}
	
	public static void sdoku(int row, int col) {
		// 행이 다채워지면 다음 행 첫번째 열 부터 시작.
		if(col == 9) {
			sdoku(row+1, 0);
			return;
		}
		
		// 행, 열이 다채워지면 출력
		if(row == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(map[row][col] == 0) {
			for(int i = 1; i<=9; i++) {
				// i 값이 중복되는지 찾음.
				// 중복되지 않는다면, (아래가 참이라면)
				if(validate(row, col, i)) {
					map[row][col] = i;
					sdoku(row, col+1);
				}
			}
			map[row][col] = 0;
			return;
		}
		sdoku(row, col+1);
	}
	
	//조건 검사
	public static boolean validate(int row, int col, int val) {
		// 가로줄 검사
		for(int i = 0; i < 9; i++) {
			if(map[row][i] == val) {
				return false;
			}
		}
		
		// 세로줄 검사
		for(int i = 0; i < 9; i++) {
			if(map[i][col] == val) {
				return false;
			}
		}
		
		// 3x3격자 검사
		int gridRow = (row/3) * 3;
		int gridCol = (col/3) * 3;
		
		for(int i = gridRow; i < gridRow+3; i++) {
			for(int j = gridCol; j < gridCol+3; j++) {
				if(map[i][j] == val) {
					return false;
				}
			}
		}
		
		return true;
	}
}
