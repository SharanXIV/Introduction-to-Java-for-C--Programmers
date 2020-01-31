// JAC444 - Workshop 8A 
// Filename:     Workshop8A.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-11-21

import java.util.Scanner;

public class Workshop8A {

	// Given functional interface.
	@FunctionalInterface
	public interface ArrayProcessor {
		double apply(double[] array);
	}

	// Counts the number of elements within entered array.
	public static ArrayProcessor counter(double value) {
		return array -> {
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] == value)
					count++;
			}
			return count;
		};
	}

	// Finds the maximum value within entered array.
	public static final ArrayProcessor maximum = array -> {
		double max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max)
				max = array[i];
		}
		return max;
	};

	// Finds the minimum value within entered array.
	public static final ArrayProcessor minimum = array -> {
		double min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min)
				min = array[i];
		}
		return min;
	};

	// Calculates the sum of the elements within the array.
	public static final ArrayProcessor sum = array -> {
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			total = total + array[i];
		}
		return total;
	};

	// Uses the sum lambda to calculate the average value of elements within array.
	public static final ArrayProcessor average = array -> sum.apply(array) / array.length;

	// Main function.
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the length of the array: ");

		int length = input.nextInt();
		double[] myArray = new double[length];

		System.out.println("Please enter the elements of the array: ");

		for (int i = 0; i < length; i++) {
			myArray[i] = input.nextInt();
		}

		System.out.println("Please enter the value you want to check in array: ");
		int value = input.nextInt();
		
		System.out.println("Minimum of array: " + minimum.apply(myArray));
		System.out.println("Maximum of array: " + maximum.apply(myArray));
		System.out.println("Sum of array: " + sum.apply(myArray));
		System.out.println("Average of array: " + average.apply(myArray));
		System.out.println("Number of " + value + "'s in the array: " + counter(value).apply(myArray));


		input.close();
	}

}