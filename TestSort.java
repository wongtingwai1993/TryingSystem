package com.sgx.regsub;

import java.util.ArrayList;
import java.util.List;

public class TestSort {

	public static void main(String... args) {
		int[] arr1 = {5, 8, 9};
		int[] arr2 = {4, 7, 8};

		int pointer1Max = arr1.length;
		int pointer2Max = arr2.length;

		int nextPointer1 = 0;
		int nextPointer2 = 0;

		List<Integer> answer = new ArrayList<>();

		while (pointer1Max > 0 && pointer2Max > 0) {
			if (arr1[nextPointer1] <= arr2[nextPointer2]) {
				answer.add(arr1[nextPointer1]);
				nextPointer1++;
				pointer1Max--;
			} else {
				answer.add(arr2[nextPointer2]);
				nextPointer2++;
				pointer2Max--;
			}
		}
		if (pointer1Max == 0) {
			// add remaining value from arr2
			for (int x = nextPointer2; x < arr2.length; x++) {
				answer.add(arr2[x]);
			}
		} else {
			// add remaining value from arr1
			for (int x = nextPointer1; x < arr1.length; x++) {
				answer.add(arr1[x]);
			}
		}
		System.out.println(answer);
	}

}