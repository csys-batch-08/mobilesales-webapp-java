package com.ajith2;
import java.util.Scanner;

public class Dummy2 {	
	static Scanner sc=new Scanner(System.in);
		public static int sumPrime(int[] arr,int s) {
			Scanner sc=new Scanner(System.in); 
			int res=0,total=0;
			
			for(int i=0;i<s;i++) {
				arr[i]=sc.nextInt();
				if(arr[i]<0) {
					System.out.println("Invalid option");
					System.exit(0);
				}
				else
					continue;
			}
			for(int j=0;j<s;j++) {
				if(arr[j]==1)
					continue;
				else {
					res=prime(arr[j]);
				if(res<1)
					total+=arr[j];
				System.out.println(res);
				}
			}
			return total;
		}
		public static int prime(int val) {
			int count=0;
			for(int i=2;i<=val/2;i++) {
				if(val%i==0)
					count+=1;
			}
			return count;
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			System.out.println("Enter the size of array :");
			int size=sc.nextInt();
			if(size<=0)
				System.out.println("Invalid option");
			else {
			int[] array=new int[size];
			System.out.println(sumPrime(array,size));
			}
		}

	}


