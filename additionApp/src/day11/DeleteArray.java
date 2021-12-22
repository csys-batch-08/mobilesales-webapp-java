package day11;

import java.util.Arrays;
import java.util.Scanner;



public class DeleteArray {
	
	public static void arrayDelete(int arr[],int num,int arr2[]) {
		int count=0;
		for(int i=0 ,k=0;i<arr.length;i++) {
			
			if(num!=arr[i]) {
				arr2[k]=arr[i];
				count++;
				k++;
			}
		}
		//return arr2;
		for(int j=0;j<count;j++) {
			System.out.println(arr2[j]);
		}
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
		int arr2[]=new int[size];
		System.out.println("Enter delete number");
		int num=sc.nextInt();
		
		arrayDelete(arr,num,arr2);
		//System.out.println(Arrays.toString(arr2));
//		for(int i=0;i<arr2.length;i++) {
//			System.out.println(arr2[i]);
//		}

	}

}
