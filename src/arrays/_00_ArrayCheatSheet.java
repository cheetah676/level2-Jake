package arrays;

import java.util.Random;

public class _00_ArrayCheatSheet {
	static Random ran = new Random();

	public static void main(String[] args) {
		// 1. make an array of 5 Strings
		String[] stringArray = { "a1", "a2", "a3", "a4", "a5" };
		// 2. print the third element in the array
		System.out.println(stringArray[2]);
		// 3. set the third element to a different value
		stringArray[2] = "b3";
		// 4. print the third element again
		System.out.println(stringArray[2]);
		// 5. use a for loop to print all the values in the array
		// BE SURE TO USE THE ARRAY'S length VARIABLE
		for (int i = 0; i < stringArray.length; i++) {
			System.out.print(stringArray[i] + ", ");
		}
		System.out.println();

		// 6. make an array of 50 integers
		int[] intArray = new int[50];
		// 7. use a for loop to make every value of the integer array a random number
		for (int i = 0; i < 50; i++) {
			intArray[i] = ran.nextInt(500);
			System.out.print(intArray[i] + ", ");
			System.out.println();
		}
		// 8. without printing the entire array, print only the smallest number in the
		// array
		int smallest = 500;
		// 9 print the entire array to see if step 8 was correct
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] < smallest) {
				smallest = intArray[i];
				System.out.print(smallest);
				System.out.println();
			}
		}
		System.out.println("Final smallest="+smallest);
		// 10. print the largest number in the array.
		int largest=0;
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] > largest) {
				largest = intArray[i];
				System.out.print(largest);
				System.out.println();
			}
		}
		System.out.print("Final largest="+largest);
	}
}
