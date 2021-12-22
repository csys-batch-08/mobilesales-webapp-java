package day11;

import java.util.Scanner;

public class EndsWithNum {
	public static int endWith(int arr[]) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
		int temp=arr[i]%10;
		if(temp==3) {
			count++;
		}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
			
		}
		for(int i=0;i<size;i++) {
			System.out.println(arr[i]);
			
		}
		System.out.println("Ends with three Count : "+endWith(arr));

	}

}
