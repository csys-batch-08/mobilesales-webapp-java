package day11;

import java.util.Arrays;
import java.util.Scanner;

public class TwoArrayAdd {
	
	public static void minOfTwo(int arr[],int arr2[]) {	
		int flag=0;
		int  flag2=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[0]) {
				flag=i;
			}
		}
		for(int i=1;i<arr2.length;i++) {
			if(arr2[i]<arr2[0]) {
				flag2=i;
			}
		}
		if(flag==flag2) {
			Arrays.sort(arr2);
		
			System.out.println("Add Two Array min : "+(arr2[1]+arr[flag]));
			
			
		}
		else {
			System.out.println("Add Two Array min : "+(arr2[flag2]+arr[flag]));
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int arr[]=new int[size];
		int arr2[]=new int[size];
		System.out.println("Enter first array");
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
			
		}
		System.out.println("Enter second array");
		for(int i=0;i<size;i++) {
			arr2[i]=sc.nextInt();
			
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
			
		
		minOfTwo(arr,arr2);
		

	}
	

}
