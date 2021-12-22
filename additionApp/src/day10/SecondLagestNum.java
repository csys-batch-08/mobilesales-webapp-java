package day10;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLagestNum {
	
	public static int[] SecondLarge(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				}
			}
		}
		return arr;
		
	}
	
	public static int product(int arr[]) {
		int sum=arr[0]*arr[arr.length-2];
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Array size");
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
				
		}
		SecondLarge(arr);
		System.out.println("Second largest number : "+arr[arr.length-2]);
		System.out.println(Arrays.toString(arr));
		System.out.println("Product value :"+product(arr));
		

	}

}
