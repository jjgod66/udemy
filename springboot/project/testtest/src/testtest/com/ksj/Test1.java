package testtest.com.ksj;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		// 10개의 정수 배열 중 가장 큰 숫자를 찾는 알고리즘
		int[] array1 = {13, 2, 3, 42, 5224, 6, 667, 8, 9, 10};
		//삽입
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
		// 버블
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
		//선택
//		int temp = 0;
//		for (int i=0; i<array1.length-1; i++) {
//			int largestIndex = i;
//			for (int j=i+1; j<array1.length; j++) {
//				if (array1[largestIndex] < array1[j]) {
//					largestIndex = j;
//				}
//			}
//			temp  = array1[i];
//			array1[i] = array1[largestIndex];
//			array1[largestIndex] = temp;
//		}
//		System.out.println(Arrays.toString(array1));
		// 10000보다 작은 숫자 중 3과 5의 배수의 총합을 구하는 함수.
//		System.out.println(sum(10000));
		
		quick(array1, 0, array1.length-1);
		System.out.println(Arrays.toString(array1));
		
	}
	
	private static void quick(int[] array1, int start, int end) {
		if (start < end) {
			int partitionIndex = partition(array1, start, end);
			
			quick(array1, start, partitionIndex-1);
			quick(array1, partitionIndex+1, end);
		}
		
	}
	
	
	private static int partition(int[] array1, int start, int end) {
		int pivot = array1[end];
		int i = (start - 1);
		
		for (int j = start; j < end; j++) {
			if (array1[j] < pivot) {
				i++;
				
				int temp = array1[i];
				array1[i] = array1[j];
				array1[j] = temp;
			}
		}
		
		int temp = array1[i+1];
		array1[i+1] = array1[end];
		array1[end] = temp;
		return i + 1;
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
