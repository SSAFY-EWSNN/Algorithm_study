package com.baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

<<<<<<< HEAD
public class Baekjoon_3085{
=======
public class Baekjoon_3085 {
>>>>>>> 463e3f6ed935b6dc19f36061033fb8c9b6c4e42e

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */
<<<<<<< HEAD
		//System.setIn(new FileInputStream("input.txt"));
=======
		System.setIn(new FileInputStream("jeongeon/input.txt"));
>>>>>>> 463e3f6ed935b6dc19f36061033fb8c9b6c4e42e
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		//StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
		
		// StringTokenize 객체 선언
		// StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
=======

		// StringTokenize 객체 선언
		// StringTokenizer st = null;

		int n = Integer.parseInt(in.readLine());

>>>>>>> 463e3f6ed935b6dc19f36061033fb8c9b6c4e42e
		//candy 배열 받기
		String[][] candy = new String[n][n];
		for(int i=0; i<n; i++) {
			String[] a = in.readLine().split("");
			for(int j=0; j<a.length; j++) {
<<<<<<< HEAD
				candy[i][j] = a[j];	
			}
		}
		
		int count = 1, max = 0;
	
		
=======
				candy[i][j] = a[j];
			}
		}

		int count = 1, max = 0;


>>>>>>> 463e3f6ed935b6dc19f36061033fb8c9b6c4e42e
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				swap(candy, i, j, i, j+1); //swap 행
				for(int x=0; x<n; x++) {
					for(int y=0; y<n-1; y++) {
						if(candy[x][y].equals(candy[x][y+1])) count += 1; //행탐색
						else count = 1;
						if(max < count) max = count;
					}
					count = 1;
				}
				for(int x=0; x<n; x++) {
					for(int y=0; y<n-1; y++) {
						if(candy[y][x].equals(candy[y+1][x])) count += 1; //열탐색
						else count = 1;
						if(max < count) max = count;
					}
					count = 1;
				}
				swap(candy, i, j+1, i, j); //다시 제자리
<<<<<<< HEAD
				
=======

>>>>>>> 463e3f6ed935b6dc19f36061033fb8c9b6c4e42e
				swap(candy, j, i, j+1, i); //swap 열
				for(int x=0; x<n; x++) {
					for(int y=0; y<n-1; y++) {
						if(candy[x][y].equals(candy[x][y+1])) count += 1; //행탐색
						else count = 1;
						if(max < count) max = count;
					}
					count = 1;
				}
				for(int x=0; x<n; x++) {
					for(int y=0; y<n-1; y++) {
						if(candy[y][x].equals(candy[y+1][x])) count += 1; //열탐색
						else count = 1;
						if(max < count) max = count;
					}
					count = 1;
				}
				swap(candy, j+1, i, j, i); //다시 제자리
			}
		}
<<<<<<< HEAD
		
		System.out.println(max);
	}
	
	 public static void swap(String[][] array, int i1, int i2, int j1, int j2) {
        String temp = array[i1][i2];
        array[i1][i2] = array[j1][j2];
        array[j1][j2] = temp;        
    }
}
=======

		System.out.println(max);
	}

	public static void swap(String[][] array, int i1, int i2, int j1, int j2) {
		String temp = array[i1][i2];
		array[i1][i2] = array[j1][j2];
		array[j1][j2] = temp;
	}
}
>>>>>>> 463e3f6ed935b6dc19f36061033fb8c9b6c4e42e