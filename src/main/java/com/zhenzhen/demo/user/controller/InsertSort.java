package com.zhenzhen.demo.user.controller;

public class InsertSort {
	
	public static void main(String[] args) {
	
		int[] arrayTemp = {2,5,32,88,23,41};
		for(int temp:arrayTemp) {
			System.out.println(temp);
		}
		
		insertSort(arrayTemp);
		System.out.println("-------------------------");
		
		for(int temp:arrayTemp) {
			System.out.println(temp);
		}
	}

	private static void insertSort(int[] arrayTemp) {
		for(int i=1;i<arrayTemp.length;i++) {
			int temp = arrayTemp[i];
			if(temp<arrayTemp[i-1]) {
				int j = 0;
				for(j=i-1;temp<arrayTemp[j];j--) {
					arrayTemp[j+1] = arrayTemp[j];
				}
				arrayTemp[j+1] = temp;
			}
		}
		
	}
	
	

}
