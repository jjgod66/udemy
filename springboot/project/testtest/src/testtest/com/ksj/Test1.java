package testtest.com.ksj;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		// 10개의 정수 배열 중 가장 큰 숫자를 찾는 알고리즘
		int[] array1 = {13, 2, 3, 42, 5224, 6, 667, 8, 9, 10};
//		int temp = 0;
//		for (int i=1; i < array1.length; i++) {
//			 for (int j=i-1; j >= 0; j--) {
//				if (array1[j+1] <= array1[j]) {
//					System.out.printf("%d %d %d %d \n", j, i, array1[j], array1[i]);
//					temp = array1[j+1];
//					array1[j+1] = array1[j];
//					array1[j] = temp;
//					System.out.println(Arrays.toString(array1));
//				} else {
//					continue; 
//				}
//			}
		
//		int temp = 0;
//		for (int i = 0; i<array1.length-1; i++) {
//			for (int j = i+1; j<array1.length; j++) {
//				if (array1[i] < array1[j]) {
//					temp = array1[i];
//					array1[i] = array1[j];
//					array1[j] = temp;
//				}
//			}
//		}
		
		int temp = 0;
		for (int i=0; i<array1.length-1; i++) {
			for (int j = i; j < array1.length-1-j; j++) {
				if (array1[j+1] > array1[j]) {
					temp = array1[j+1];
					array1[j+1] = array1[j];
					array1[j] = temp;
					System.out.println("안녕하세요");
				}
				System.out.println(Arrays.toString(array1));
				
			}
		}
		
		// 10000보다 작은 숫자 중 3과 5의 배수의 총합을 구하는 함수.
//		System.out.println(sum(10000));
	}
	private static int sum(int high) {
		int sum = 0;
		for (int i=1; i<high; i++) {
			if (i%3 != 0 && i%5 != 0) continue;
			sum += i;
		}
		return sum;
	}

}
