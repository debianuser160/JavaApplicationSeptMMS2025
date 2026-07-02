import java.util.Arrays;

public class UsingArraysClass{
	public static void main(String[] args){
		int[] numbers = {5,8,2,3,9,4,1,6,7,10};
		int[] a = {8,9,6};
		int[] b = {8,9,6};
		
		int[] c = {1,3,6};
		int[] d = {1,3,5};
		
		int[] e = {1,2,5};
		int[] f = {1,3,5};
		
		int[] g = {1,3,5};
		int[] h = {1,3,5};
		
		int[] myFillArrs = new int[10];
		Arrays.fill(myFillArrs,5);
		Arrays.sort(numbers);
		System.out.println("The elements of the array are: ");
		
		for(int number : numbers){
			System.out.printf("%d%n",number);
		}
		System.out.println("Binary search: ");
		int index = Arrays.binarySearch(numbers,9);
		
		System.out.printf("the index number of the element 9 is: %d%n",index);
		
		boolean isEquals = Arrays.equals(a,b);
		System.out.printf("%b%n",isEquals);
		
		int properCompare = Arrays.compare(c,d);
		System.out.printf("%d%n",properCompare);
		
		int improperCompare = Arrays.compare(e,f);
		System.out.printf("%d%n",improperCompare);
		
		int equalCompare = Arrays.compare(g,h);
		System.out.printf("%d%n",equalCompare);
		
		System.out.println("my fill arrays are: ");
		for(int nummber : myFillArrs){
			System.out.printf("%d%n",nummber);
		}
		
		int[] evenNumbers = {2,4,6,8,10,12,14,16,18,20};
		int[] copyArr = Arrays.copyOf(evenNumbers,5);
		
		System.out.println("The element of copyarr are: ");
		for(int arrr : copyArr){
			System.out.printf("%d%n",arrr);
		}
		
		System.out.println(Arrays.toString(evenNumbers));
		
		int[][] multiArr = {
			{7,8,6},
			{7,7,4}
		};
		System.out.println(Arrays.deepToString(multiArr));
	}
} 

/*The Arrays.fill method assigns a specified value to every element (or a range of elements) in an array. 
It has overloads for all primitive types and Object[]. For example, 
Arrays.fill(arr, val) sets all elements of arr to val, while Arrays.fill(arr, fromIdx, toIdx, val) 
sets elements in the range [fromIdx, toIdx).*/