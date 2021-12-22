package day12;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size");
		int size=sc.nextInt();
		
		int arr[]=new int[size];
		System.out.println("Enter  array");
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
			
		}
		int last=arr.length-1;
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Search the element");
		int num=sc.nextInt();
		binary(arr,last,num);

	}
	
	public static void binary(int arr[],int last,int num) {
		int first=0;
		int mid=(first+last)/2;
		while(first<=last) {
			
		
		if(arr[mid]==num) {
			System.out.println("The element index is found : "+mid);
			break;
			
		}
		else if(num>arr[mid]) 
		{
			first=mid+1;
			
		}
		else if(num<arr[mid]) 
		{
			last=mid-1;
		}
		mid=(first+last)/2;
		System.out.println(first+" "+ last);
		if(first>last) {
			System.out.println("The Element is not Found ");
		}
		
		}
		
	}

}
