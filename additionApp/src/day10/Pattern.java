package day10;

import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the row");
		int row=sc.nextInt();
		
		pattern1(row);
		pattern2(row);
		pattern3(row);
		
		// TODO Auto-generated method stub
		
		

	}
	public static void pattern1(int row) {
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	public static void pattern2(int row) {
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	public static void pattern3(int row) {
		int count=row-1;
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=count;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print(i);
			}
			
			System.out.println();
			count--;
		}
		
		
	}
	
	

}
