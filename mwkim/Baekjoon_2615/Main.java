import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	static int[] dx = {0, 1, 1, 1};
	static int[] dy = {1, -1, 0, 1};
	static boolean[][][] visited = new boolean[19][19][4];
	static int[] answer = new int[2];

	static final int NONE = 0;
	static final int BLACK = 1;
	static final int WHITE = 2;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과 출력을 위한 스트링빌더 생성.
		StringBuilder sb = new StringBuilder();
		map = new int[19][19];

		for(int i = 0; i < 19; i++) {
			String[] pan = in.readLine().split(" ");
			for(int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(pan[j]);
			}
		}

		for(int x = 0; x < 19; x++) {
			for(int y = 0; y < 19; y++) {
				if(map[x][y] == BLACK || map[x][y] == WHITE) {
					fivemok(x, y, 1);
				}
			}
		}
		sb.append(answer[0]).append(" ").append(answer[1]);
		System.out.println(sb);
	}

	public static void fivemok(int x, int y, int count) {
		int cur = map[x][y];
		
		for(int i = 0; i < 4; i++) {
			if(!visited[x][y][i]) {
				visited[x][y][i] = true;
				int nextX = x + dx[i], nextY = y + dy[i];
				if(isRange(nextX, nextY) && map[nextX][nextY] == cur) {
					fivemok(nextX, nextY, count+1);
				}
			}
		}
		if(count != 5) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			answer[0] = 0;
			answer[1] = 0;
		}
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < 19 && 0 <= y && y < 19;
	}
}
