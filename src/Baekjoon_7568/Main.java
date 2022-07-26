package Baekjoon_7568;

import java.util.Scanner;

class Who{
	int height;
	int weight;
	int pos;
	
	public Who(int h, int w) {
		this.height = h;
		this.weight = w;
		this.pos = 0;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		Who[] whos = new Who[T];
		
		for(int tc = 0; tc < T; tc++) {
			String[] str = sc.nextLine().split(" ");
			int h = Integer.parseInt(str[0]);
			int w = Integer.parseInt(str[1]);
			whos[tc] = new Who(h, w);
		}
		
		for(int i = 0; i < T-1; i++) {
			for(int j = i+1; j < T; j++) {
				System.out.printf("i: %d vs j: %d\n", i, j);
				if(whos[i].height > whos[j].height && whos[i].weight > whos[j].weight) {
					whos[j].pos++;
				} else if(whos[i].height < whos[j].height && whos[i].weight < whos[j].weight) {
					whos[i].pos++;
				}
				
			}
		}
		
		for(int i = 0; i < T; i++) {
			System.out.printf("%d ", whos[i].pos + 1);
		}
		System.out.println();
		
		
		sc.close();
	}
}
