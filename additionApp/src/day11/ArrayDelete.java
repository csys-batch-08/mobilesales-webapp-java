package day11;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDelete {
	
	public static int[] arrayDelete(int arr[],int num) {
		for(int i=0;i<arr.length;i++) {
			
				if(num==arr[i]) {
					for(int j=i;j<arr.length-1;j++) {
					arr[j]=arr[j+1];
					System.out.println(Arrays.toString(arr));
					}
					arr[arr.length-1]=0;
					
					//break;
				}
				
			
		}
		return arr;
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
		System.out.println("Enter delete number");
		int num=sc.nextInt();
		
		arrayDelete(arr,num);
		System.out.println(Arrays.toString(arr));

	}

}
