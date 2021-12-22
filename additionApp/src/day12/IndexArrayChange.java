package day12;

import java.util.Arrays;
import java.util.Scanner;

public class IndexArrayChange {
	
	public static void orderChange(int arr[],int arr2[],int arr3[]) {
		for(int i=0;i<arr.length;i++) {
			arr3[arr2[i]]=arr[i];
		}
		System.out.println("Result"+Arrays.toString(arr3));
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size");
		int size=sc.nextInt();
		int arr[]=new int[size];
		int arr2[]=new int[size];
		int arr3[]=new int[size];
		System.out.println("Enter first array");
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
			
		}
		System.out.println("Enter second array");
		for(int i=0;i<size;i++) {
			
			arr2[i]=sc.nextInt();
			if(arr2[i]>=size) {
				System.out.println("Invalid");
				System.exit(0);
			}
			
		}
		
		System.out.println("Array element : "+Arrays.toString(arr));
		System.out.println("Changing index number : "+Arrays.toString(arr2));
		orderChange(arr,arr2,arr3);

	}

}
